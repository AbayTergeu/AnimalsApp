package com.abter.springmvc;

import com.abter.springmvc.dao.AbstractDao;
import com.abter.springmvc.model.Animals;
import com.abter.springmvc.model.AutorDetail;
import com.abter.springmvc.model.Person;
import com.abter.springmvc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * Created by tergeusizov on 4/27/2016.
 */
public class TestApp extends AbstractDao<Integer, Animals>{
    public static void main(String[] args){
        System.out.println("Hibernate one to one (XML mapping)");



        Session session = HibernateUtil.getSessionFactory().openSession();

        /*session.beginTransaction();

        Person person = new Person();

        person.setLogin("Test_3");
        person.setPassw("passw_3");

        AutorDetail autorDetail = new AutorDetail();
        autorDetail.setCntAut(3);
        autorDetail.setDateEnd(new Date());
        autorDetail.setDateStart(new Date());

        person.setAutorDetail(autorDetail);
        autorDetail.setPerson(person);



        session.save(person);


        AutorDetail autorDetail1 = person.getAutorDetail();

        System.out.println("autorDetail1.getCntAut() = " + autorDetail1.getCntAut());

        session.getTransaction().commit();*/
        /*session.beginTransaction();
        Integer personId = 34;
        Person person =  (Person) session.get(Person.class, personId);

        AutorDetail autorDetail1 = person.getAutorDetail();

        Set<Animals> animalsSet = person.getAnimalses();
        if (animalsSet.size() > 0){
            for (Animals animals : animalsSet) {
                System.out.println(animals.getAnimalName());
            }

        }

        //System.out.println("autorDetail1.getCntAut() = " + autorDetail1.getCntAut());
        session.getTransaction().commit();
        session.close();
        System.out.println("Done");*/


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2016-04-12";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date currentDate = new Date();
        Long time = currentDate.getTime();
        System.out.println("1   Date currentDate = " + currentDate);
        long anotherDate = 1;
        time = time + (60*60*1000*anotherDate);
        currentDate = new Date(time);
        System.out.println("2   Date currentDate = " + currentDate);
    }
}
