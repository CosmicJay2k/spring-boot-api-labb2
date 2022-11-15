package com.example.labb2.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.labb2.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findById(long id);
}
