package com.abter.springmvc.service;

import com.abter.springmvc.dao.AnimalDao;
import com.abter.springmvc.model.Animals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("animalsService")
@Transactional
public class AnimalsServiceImp implements AnimalsService{
    @Autowired
    AnimalDao animalDao;

    /*
    * Method for find animal by id
    * */
    public Animals findById(Integer id){
        Animals animals = animalDao.findById(id);
        return animals;
    }

    /**Method for save new Animals*/
    public void save(Animals animals){
        animalDao.save(animals);
    }

    /*
    * Method for checking the unique name
    * */
    public boolean ifExistsName(String name){
        return animalDao.ifExistsName(name);
    }

    /*Method for delete Animal in bd*/
    public void deleteById(Integer id) {
        animalDao.deleteById(id);
    }

    /*Method for update animals*/
    public void saveOrUpdate(Animals animals){
        animalDao.saveOrUpdate(animals);
    }

    /*Method for find all Animals*/
    public List<Animals> findAllAnimalss(){
      return animalDao.findAllAnimalss();
    };
}
