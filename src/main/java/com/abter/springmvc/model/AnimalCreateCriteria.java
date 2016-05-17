package com.abter.springmvc.model;


public class AnimalCreateCriteria {
    private String animalName;
    private String dateBirth;
    private String sex;
    private String id;

    public AnimalCreateCriteria() {
    }

    public AnimalCreateCriteria(String animalName, String dateBirth, String sex) {
        this.animalName = animalName;
        this.dateBirth = dateBirth;
        this.sex = sex;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
