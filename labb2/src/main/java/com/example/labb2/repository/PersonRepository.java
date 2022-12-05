package com.example.labb2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.example.labb2.entity.Person;
import com.example.labb2.view.PersonView;

public interface PersonRepository extends ListCrudRepository<Person, Long> {

    @Query(value = "SELECT first_name as firstName, last_name as lastName FROM person p WHERE id = :id", nativeQuery = true)
    PersonView viewById(long id);
}
