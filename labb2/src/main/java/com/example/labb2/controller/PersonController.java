package com.example.labb2.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.labb2.entity.Person;
import com.example.labb2.repository.PersonRepository;

@RestController
public class PersonController {

    PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        var myPerson = personRepository.save(person);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(myPerson.getId())
                .toUri();

        return ResponseEntity.created(location).body(myPerson);
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personRepository.findById(id);
    }

    @GetMapping("/person")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}