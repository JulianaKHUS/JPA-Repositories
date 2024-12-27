package program.springdatajpa1.repository;

import com.example.demo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Person save(Person person) {
        if (person.getId() == null) {
            entityManager.persist(person);
            return person;
        } else {
            return entityManager.merge(person);
        }
    }

    public Optional<Person> getPersonById(Long id) {
        return Optional.ofNullable(entityManager.find(Person.class, id));
    }

    public void deleteById(Long id) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
    }

    public List<Person> getAllPersons() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public List<Person> getPersonsByCity(String city) {
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    public List<Person> getPersonsYoungerThan(int age) {
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.age < :age ORDER BY p.age ASC", Person.class);
        query.setParameter("age", age);
        return query.getResultList();
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname", Person.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.getResultList().stream().findFirst();
    }
}
