package com.abter.springmvc.controller;

import com.abter.springmvc.jsonview.Views;
import com.abter.springmvc.model.*;
import com.abter.springmvc.service.AnimalsService;
import com.abter.springmvc.service.PersonService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
    @Autowired
    AnimalsService animalsService;

    @Autowired
    PersonService personService;

    /**
     * This method for rest service by json check login
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/search/getCheckResult")
    public AjaxResponseBody getSearchResultViaAjax(@RequestBody PersonSearchCriteria search) {

        AjaxResponseBody result = new AjaxResponseBody();
        Person person = personService.findByLogin(search.getUsername());
        if(person!=null){
            result.setCode("200");
            result.setMsg("success");
            result.setResult(person);
        } else {
            result.setCode("204");
            result.setMsg("No user!");
        }
        return result;

    }

    /**
     * This method for rest service by json get detail animal
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/detail/getDetailResult")
    public AjaxResponseBody getDetailAnimal(@RequestBody AnimalCreateCriteria animalCreateCriteria) {
        AjaxResponseBody result = new AjaxResponseBody();
        Animals animals = animalsService.findById(Integer.parseInt(animalCreateCriteria.getId()));
        if(animals!=null){
            result.setCode("200");
            result.setMsg("success");
            result.setResultAnimal(animals);
        } else {
            result.setCode("204");
            result.setMsg("No user!");
        }
        return result;
    }
}
