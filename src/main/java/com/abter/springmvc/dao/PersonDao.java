package com.abter.springmvc.dao;

import com.abter.springmvc.model.Person;

public interface PersonDao {
    /*
    * Method for find Person by login
    * */
    public Person findByLogin(String login);

    /**Method for save new Person*/
    public void save(Person person);

    /*
    * Method for checking the unique login
    * */
    public boolean ifExistsLogin(String login);

    /*
    * Method for checking the unique login
    * */
    public Person findByLoginAndPsw(String login, String passw);
    /*
    * Method for find Person by id
    * */
    public Person findById(Integer id);
}
