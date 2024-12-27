package program.springdatajpa1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONS")
@IdClass(PersonId.class)
public class Person {

    @Id
    private String name;

    @Id
    private String surname;

    @Id
    private int age;

    private String phoneNumber;
    private String cityOfLiving;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }
}

