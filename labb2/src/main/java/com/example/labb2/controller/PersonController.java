package com.example.labb2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.labb2.entity.Person;
import com.example.labb2.repository.PersonRepository;

@RestController
public class PersonController {

    PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    public Person getPersonByFirstName(@RequestParam String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    @PostMapping("/person")
    public String addPerson(@RequestBody Person person) {
        personRepository.save(person);
        return "Person saved!";
    }

}