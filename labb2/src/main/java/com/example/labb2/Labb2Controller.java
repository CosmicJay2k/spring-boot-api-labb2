package com.example.labb2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Labb2Controller {

    PersonRepository personRepository;

    public Labb2Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) {
        personRepository.save(person);
        return "Person saved!";
    }

}