package com.example.labb2.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.labb2.entity.Person;

public interface PersonRepository extends ListCrudRepository<Person, Long> {

    Person findById(long id);
}
