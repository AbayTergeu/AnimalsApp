package com.abter.springmvc.model;

import com.abter.springmvc.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person", catalog = "test", uniqueConstraints = {@UniqueConstraint(columnNames = "login")})
public class Person implements Serializable{
    @JsonView(Views.Public.class)
    private Integer personId;
    @JsonView(Views.Public.class)
    private String login;
    @JsonView(Views.Public.class)
    private String passw;

    private Set<Animals> animalses =  new HashSet<Animals>();
    private AutorDetail autorDetail;

    public Person() {
    }

    public Person(String login, String passw) {
        this.login = login;
        this.passw = passw;
    }

    public Person(String login, String passw, Set<Animals> animalses) {
        this.login = login;
        this.passw = passw;
        this.animalses = animalses;
    }

    public Person(String login, String passw, Set<Animals> animalses, AutorDetail autorDetail) {
        this.login = login;
        this.passw = passw;
        this.animalses = animalses;
        this.autorDetail = autorDetail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID", unique = true, nullable = false)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    @Column(name = "login", unique = true, nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    @Column(name = "passw", nullable = false)
    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    public Set<Animals> getAnimalses() {
        return animalses;
    }

    public void setAnimalses(Set<Animals> animalses) {
        this.animalses = animalses;
    }
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    public AutorDetail getAutorDetail() {
        return autorDetail;
    }

    public void setAutorDetail(AutorDetail autorDetail) {
        this.autorDetail = autorDetail;
    }


}
