package com.spring.cassandra.service;

import com.spring.cassandra.model.Person;
import com.spring.cassandra.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getPersonById(UUID id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find this person by ID"));
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public void createPersons(Person oldPerson) {
        for (int i = 0; i < 10000 ; i++) {
            Person person = new Person();
            person.setName(oldPerson.getName());
            person.setAge(oldPerson.getAge());
            person.setEmail(oldPerson.getEmail());
            personRepository.save(person);
        }

    }

    public Person updatePerson(UUID id, Person person) {
        Person updatedPerson = getPersonById(id);

        updatedPerson.setName(person.getName());
        updatedPerson.setAge(person.getAge());
        updatedPerson.setEmail(person.getEmail());

        return personRepository.save(updatedPerson);
    }

    public void deletePerson (UUID id){
        Person deletedPerson = getPersonById(id);
        personRepository.delete(deletedPerson);
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }
}
