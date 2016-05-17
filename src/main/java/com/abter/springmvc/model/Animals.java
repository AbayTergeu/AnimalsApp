package com.abter.springmvc.model;

import com.abter.springmvc.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "animals", catalog = "test", uniqueConstraints = @UniqueConstraint(columnNames = "animal_name"))
public class Animals implements Serializable{
    @JsonView(Views.Public.class)
    private Integer animalId;
    @JsonView(Views.Public.class)
    private String animalName;
    @JsonView(Views.Public.class)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dateBirth;
    @JsonView(Views.Public.class)
    private String sex;
    //@JsonView(Views.Public.class)
    private Person person;

    public Animals() {
    }

    public Animals(String animalName, Date dateBirth, String sex, Person person) {
        this.animalName = animalName;
        this.dateBirth = dateBirth;
        this.sex = sex;
        this.person = person;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id", unique = true, nullable = false)
    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }
    @Column(name = "animal_name", unique = true, nullable = false)
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "date_birth", nullable = false, length = 10)
    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Column(name = "sex", nullable = false)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @ManyToOne
    @JoinColumn(name = "PERSON_ID", nullable = false)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
