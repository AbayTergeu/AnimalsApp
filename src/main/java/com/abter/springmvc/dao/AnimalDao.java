package com.abter.springmvc.dao;

import com.abter.springmvc.model.Animals;
import java.util.Date;
import java.util.List;

public interface AnimalDao {
    /*
    * Method for find animal by id
    * */
    public Animals findById(Integer id);

    /**Method for save new Animals*/
    public void save(Animals animals);

    /*
    * Method for checking the unique name
    * */
    public boolean ifExistsName(String name);

    /*Method for delete Animal in bd*/
    public void deleteById(Integer id);

    /*Method for update animals*/
    public void saveOrUpdate(Animals animals);

    /*Method for find all Animals*/
    public List<Animals> findAllAnimalss();
}
