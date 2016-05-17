package com.abter.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.abter.springmvc.jsonview.Views;
import com.abter.springmvc.model.*;
import com.abter.springmvc.service.AnimalsService;
import com.abter.springmvc.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.annotation.JsonView;
import javax.validation.Valid;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

    @Autowired
    PersonService personService;

    @Autowired
    AnimalsService animalsService;

    /**
     * This is welcome page
     */
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String getUserByLogin(ModelMap model) {
        PersonSearchCriteria personSearchCriteria = new PersonSearchCriteria();
        model.addAttribute("personSearchCriteria", personSearchCriteria);
        return "welcome";
    }

    /*This method Sign in app if login and password correct*/
    @RequestMapping(value = {"/signIn", "/list"})
    public String getSearchResultViaAjax(@ModelAttribute("personSearchCriteria") PersonSearchCriteria personSearchCriteria, ModelMap model) {
        Person person = personService.findByLoginAndPsw(personSearchCriteria.getUsername(), personSearchCriteria.getPassword());
        Date date = new Date();
        if(person!=null){
            if(person.getAutorDetail()!=null){
                if(person.getAutorDetail().getDateEnd()!=null ||date.before(person.getAutorDetail().getDateEnd()) ){
                    model.addAttribute("errorTxt", "Within an hour, you can not authenticate more than 10 times!");
                    model.addAttribute("hasErr", true);
                    return "welcome";
                }
            }

            List<Animals> animalsList = new ArrayList<Animals>();
            Set<Animals> animalsSet = person.getAnimalses();
            model.addAttribute("animalsList", animalsSet);
            model.addAttribute("personId", person.getPersonId());

            return "animalslist";
        }else{
            Person person1 = personService.findByLogin(personSearchCriteria.getUsername());
            //If login exists, but psw not correct increment count
            if(person1!=null){
                if(person1.getAutorDetail()!=null){
                    if(date.after(person1.getAutorDetail().getDateStart())){
                        person1.getAutorDetail().setCntAut(person1.getAutorDetail().getCntAut()+1);
                    }else{
                        if(person1.getAutorDetail().getCntAut()<10){
                            person1.getAutorDetail().setCntAut(0);
                            person1.getAutorDetail().setDateStart(null);
                            person1.getAutorDetail().setDateEnd(null);
                        }
                    }

                    if(person1.getAutorDetail().getCntAut()>10){
                        Long time = person1.getAutorDetail().getDateStart().getTime();
                        time = time + (60*60*1000);
                        person1.getAutorDetail().setDateEnd(new Date(time));

                        model.addAttribute("errorTxt", "Within an hour, you can not authenticate more than 10 times!");
                        model.addAttribute("hasErr", true);
                        return "welcome";
                    }


                }else{
                    AutorDetail autorDetail = new AutorDetail();
                    autorDetail.setCntAut(1);
                    autorDetail.setDateStart(new Date());
                    person1.setAutorDetail(autorDetail);
                }
            }
            model.addAttribute("errorTxt", "Please check your Login or password! It's not correct!");
            model.addAttribute("hasErr", true);
            return "welcome";
        }
    }
    /**
     * This method call registration form for create Animal by person id
     */
    @RequestMapping(value = { "/newanimal-{personId}" }, method = RequestMethod.GET)
    public String newAnimal(@PathVariable String personId, ModelMap model) {
        AnimalCreateCriteria animalCreateCriteria = new AnimalCreateCriteria();
        model.addAttribute("animalCreateCriteria", animalCreateCriteria);
        System.out.println("1   personId = " + personId);
        model.addAttribute("personId", personId);
        model.addAttribute("edit", false);
        return "registration";
    }
    /**
     * This method call registration form for update Animal by animal id and person id
     */
    @RequestMapping(value = { "/updanimal-{animalId}-{personId}" }, method = RequestMethod.GET)
    public String updAnimal(@PathVariable String personId, @PathVariable String animalId, ModelMap model) {
        Animals animals = animalsService.findById(Integer.parseInt(animalId));
        model.addAttribute("animals", animals);
        AnimalCreateCriteria animalCreateCriteria = new AnimalCreateCriteria();
        model.addAttribute("animalCreateCriteria", animalCreateCriteria);
        model.addAttribute("personId", personId);
        model.addAttribute("edit", true);
        return "registration";
    }
    /**
     * This method get list animals by person id
     */
    @RequestMapping(value = { "/list-{personId}" }, method = RequestMethod.GET)
    public String getAnimalList(@PathVariable String personId, ModelMap model) {
        Person person = personService.findById(Integer.parseInt(personId));
        if(person!=null){
            List<Animals> animalsList = new ArrayList<Animals>();
            Set<Animals> animalsSet = person.getAnimalses();
            model.addAttribute("animalsList", animalsSet);
            model.addAttribute("personId", person.getPersonId());

            return "animalslist";
        }else{
            return "welcome";
        }
    }
    /**
     * This method will be called on form submission, handling POST request for
     * creating animal in database. It also validates the user input
     */
    @RequestMapping(value = { "/animalCr-{personId}" }, method = RequestMethod.POST)
    public String CrAnimal(@Valid AnimalCreateCriteria animalCreateCriteria, @PathVariable String personId, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "registration";
        }
        if (animalsService.ifExistsName(animalCreateCriteria.getAnimalName())) {
            FieldError nameError = new FieldError("animals", "animalName", "Animal name {" + animalCreateCriteria.getAnimalName() + "} already exist. Please fill in different value");
            result.addError(nameError);
            return "registration";
        }
        if(!animalCreateCriteria.getSex().equals("1")){
            if(!animalCreateCriteria.getSex().equals("0")) {
                FieldError nameError = new FieldError("animals", "sex", "Animal sex {"+animalCreateCriteria.getSex()+"} value is invalid. Please enter 1 or 0");
                result.addError(nameError);
                return "registration";
            }
        }
        Animals animals = null;
        animals = new Animals();
        animals.setAnimalName(animalCreateCriteria.getAnimalName());
        animals.setSex(animalCreateCriteria.getSex());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = animalCreateCriteria.getDateBirth();
        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));
            animals.setDateBirth(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Person person = personService.findById(Integer.parseInt(personId));
        animals.setPerson(person);
        model.addAttribute("personId", personId);
        animalsService.save(animals);
        model.addAttribute("success", "Animal " + animalCreateCriteria.getAnimalName() + " registered successfully");
        return "registrationsuccess";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating animal in database. It also validates the user input
     */
    @RequestMapping(value = { "/animalUpd-{personId}-{animalId}" }, method = RequestMethod.POST)
    public String UpdAnimal(@Valid AnimalCreateCriteria animalCreateCriteria, @PathVariable String personId, @PathVariable String animalId, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "registration";
        }
        if(!animalCreateCriteria.getSex().equals("1")){
            if(!animalCreateCriteria.getSex().equals("0")) {
                FieldError nameError = new FieldError("animals", "sex", "Animal sex {"+animalCreateCriteria.getSex()+"} value is invalid. Please enter 1 or 0");
                result.addError(nameError);
                return "registration";
            }
        }
        Animals animals = animalsService.findById(Integer.parseInt(animalId));

        animals.setAnimalName(animalCreateCriteria.getAnimalName());
        animals.setSex(animalCreateCriteria.getSex());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = animalCreateCriteria.getDateBirth();
        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));
            animals.setDateBirth(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Person person = personService.findById(Integer.parseInt(personId));
        animals.setPerson(person);
        model.addAttribute("personId", personId);
        animalsService.saveOrUpdate(animals);
        model.addAttribute("success", "Animal " + animalCreateCriteria.getAnimalName() + " updated successfully");
        return "registrationsuccess";
    }

    /**
     * This method will delete an animal by it's id value.
     */
    @RequestMapping(value = { "/delanimal-{animalId}-{personId}" }, method = RequestMethod.GET)
    public String deleteAnimal(@PathVariable String animalId, @PathVariable String personId, ModelMap model) {
        animalsService.deleteById(Integer.parseInt(animalId));
        Person person = personService.findById(Integer.parseInt(personId));
        if(person!=null){
            List<Animals> animalsList = new ArrayList<Animals>();
            Set<Animals> animalsSet = person.getAnimalses();
            model.addAttribute("animalsList", animalsSet);
            model.addAttribute("personId", person.getPersonId());

            return "redirect:/list-"+personId;
        }else{
            return "redirect:/";
        }
    }

    /**
     * This is registration page for person
     */
    @RequestMapping(value = { "/reg"}, method = RequestMethod.GET)
    public String regNewPerson(ModelMap model) {
        PersonSearchCriteria personSearchCriteria = new PersonSearchCriteria();
        model.addAttribute("personSearchCriteria", personSearchCriteria);
        return "personreg";
    }

    /**
     * This is check page for person
     */
    @RequestMapping(value = { "/check_login"}, method = RequestMethod.GET)
    public String checkLogin(ModelMap model) {
        return "checkLogin";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * creating person in database. It also validates the user input
     */
    @RequestMapping(value = { "/create_person" }, method = RequestMethod.POST)
    public String crPerson(@Valid PersonSearchCriteria personSearchCriteria, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "personreg";
        }
        if(!personSearchCriteria.getPassword().equals(personSearchCriteria.getPasswConf())) {
            FieldError nameError = new FieldError("personSearchCriteria", "password", "Passwords do not match! Please re-enter passwords.");
            result.addError(nameError);
            return "personreg";
        }
        Person person = new Person();
        person.setLogin(personSearchCriteria.getUsername());
        person.setPassw(personSearchCriteria.getPassword());
        personService.save(person);
        return "redirect:/";
    }



}
