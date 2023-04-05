package com.spring.mongo.controller;

import com.spring.mongo.model.Person;
import com.spring.mongo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo")
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
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
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
