package com.example.appspringdata.controller;

import com.example.appspringdata.domain.Person;
import com.example.appspringdata.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPersons() {
        return ResponseEntity.ok(personRepository.findAll());
    }

    @GetMapping(value = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPerson(@PathVariable String id) {
        return ResponseEntity.ok(personRepository.findById(id));
    }

    @PostMapping(value = "/persons",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/persons/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable String id) {
        personRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
