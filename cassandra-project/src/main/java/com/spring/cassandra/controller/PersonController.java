package com.spring.cassandra.controller;

import com.spring.cassandra.model.Person;
import com.spring.cassandra.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cassandra")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable UUID id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @PostMapping("/fill")
    public ResponseEntity<String> createPersons(@RequestBody Person person) {
        personService.createPersons(person);
        return ResponseEntity.ok("10000 Person saved!");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        personService.deleteAll();
        return ResponseEntity.ok("Deleted all!");
    }

}
