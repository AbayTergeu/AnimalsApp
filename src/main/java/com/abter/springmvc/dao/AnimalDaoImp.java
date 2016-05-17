package com.abter.springmvc.dao;

import com.abter.springmvc.model.Animals;
import com.abter.springmvc.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("animalDao")
public class AnimalDaoImp extends AbstractDao<Integer, Animals> implements AnimalDao{
    /*
    * Method for find animal by id
    * */
    public Animals findById(Integer id){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("animalId", id));
        Animals animals = (Animals)criteria.uniqueResult();
        return animals;
    }

    /**Method for save new Animals*/
    public void save(Animals animals){
        persist(animals);
    }

    /*
    * Method for checking the unique name
    * */
    public boolean ifExistsName(String name){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("animalName", name));
        Animals animals = (Animals)criteria.uniqueResult();
        if(animals!=null){
            return true;
        }
        return false;
    }

    /*Method for delete Animal in bd*/
    public void deleteById(Integer id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("animalId", id));
        Animals animals = (Animals)crit.uniqueResult();
        delete(animals);
    }

    /*Method for update animals*/
    public void updAnimal(Animals animals){
        saveOrUpdate(animals);
    }

    /*Method for find all Animals*/
    public List<Animals> findAllAnimalss() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("animalName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Animals> animalsList = (List<Animals>) criteria.list();
        return animalsList;
    }

}
