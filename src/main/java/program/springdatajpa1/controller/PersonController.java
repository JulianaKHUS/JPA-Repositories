package program.springdatajpa1.controller;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository personRepository;


    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public ResponseEntity<Person> createOrUpdatePerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personRepository.getPersonById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    @GetMapping("/city/{city}")
    public List<Person> getPersonsByCity(@PathVariable String city) {
        return personRepository.getPersonsByCity(city);
    }

    @GetMapping("/younger-than/{age}")
    public List<Person> getPersonsYoungerThan(@PathVariable int age) {
        return personRepository.getPersonsYoungerThan(age);
    }

    @GetMapping("/name/{name}/surname/{surname}")
    public ResponseEntity<Person> getPersonByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        Optional<Person> person = personRepository.getPersonByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
