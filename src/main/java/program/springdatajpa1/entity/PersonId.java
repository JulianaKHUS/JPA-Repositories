package program.springdatajpa1.entity;

import java.io.Serializable;
import java.util.Objects;

public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;

    public PersonId() {
    }

    public PersonId(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
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

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PersonId personId = (PersonId) obj;
        return age == personId.age &&
                Objects.equals(name, personId.name) &&
                Objects.equals(surname, personId.surname);
    }
}

