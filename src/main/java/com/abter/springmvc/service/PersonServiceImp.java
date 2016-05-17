package com.abter.springmvc.service;

import com.abter.springmvc.dao.PersonDao;
import com.abter.springmvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
@Transactional
public class PersonServiceImp implements PersonService {
    @Autowired
    private PersonDao personDao;

    /*
    * Method for find Person by login
    * */
    public Person findByLogin(String login) {
        Person person = personDao.findByLogin(login);
        return person;
    }

    /**Method for save new Person*/
    public void save(Person person){
        personDao.save(person);
    };

    /*
    * Method for checking the unique login
    * */
    public boolean ifExistsLogin(String login){
        return personDao.ifExistsLogin(login);
    };

    /*
    * Method for checking the unique login
    * */
    public Person findByLoginAndPsw(String login, String passw){
        return personDao.findByLoginAndPsw(login, passw);
    }

    /*
    * Method for find Person by id
    * */
    public Person findById(Integer id){
        return personDao.findById(id);
    };
}
