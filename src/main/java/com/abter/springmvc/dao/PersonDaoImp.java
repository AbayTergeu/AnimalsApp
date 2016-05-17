package com.abter.springmvc.dao;

import com.abter.springmvc.model.Person;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImp extends AbstractDao<Integer, Person> implements PersonDao{
    /*
    * Method for find Person by login
    * */
    public Person findByLogin(String login){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("login", login));
        Person person = (Person)criteria.uniqueResult();
        if(person!=null){
            Hibernate.initialize(person.getAnimalses());
            Hibernate.initialize(person.getAutorDetail());
        }
        return person;
    }

    /**Method for save new Person*/
    public void save(Person person){
        persist(person);
    }

    /*
    * Method for checking the unique login
    * */
    public boolean ifExistsLogin(String login){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("login", login));
        Person person = (Person)criteria.uniqueResult();
        if(person!=null){
            return true;
        }
        return false;
    }

    /*
    * Method for checking the unique login
    * */
    public Person findByLoginAndPsw(String login, String passw){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("login", login));
        criteria.add(Restrictions.eq("passw", passw));
        Person person = (Person)criteria.uniqueResult();
        if(person!=null){
            Hibernate.initialize(person.getAnimalses());
            Hibernate.initialize(person.getAutorDetail());
        }
        return person;
    }

    /*
    * Method for find Person by id
    * */
    public Person findById(Integer id){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("personId", id));
        Person person = (Person)criteria.uniqueResult();
        if(person!=null){
            Hibernate.initialize(person.getAnimalses());
            Hibernate.initialize(person.getAutorDetail());
        }
        return person;
    }

}


