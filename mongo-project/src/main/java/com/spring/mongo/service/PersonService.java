package com.spring.mongo.service;

import com.spring.mongo.model.Person;
import com.spring.mongo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getPersonById(String id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find this person by ID"));
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public void createPersons(Person oldPerson) {
        for (int i = 0; i < 10000; i++) {
            Person person = new Person();
            person.setName(oldPerson.getName());
            person.setAge(oldPerson.getAge());
            person.setEmail(oldPerson.getEmail());
            personRepository.save(person);
        }

    }

    public Person updatePerson(String id, Person person) {
        Person updatedPerson = getPersonById(id);

        updatedPerson.setName(person.getName());
        updatedPerson.setAge(person.getAge());
        updatedPerson.setEmail(person.getEmail());

        return personRepository.save(updatedPerson);
    }

    public void deletePerson(String id) {
        Person deletedPerson = getPersonById(id);
        personRepository.delete(deletedPerson);
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }
}
