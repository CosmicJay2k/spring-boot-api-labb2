package com.example.labb2.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.labb2.entity.Car;

public interface CarRepository extends ListCrudRepository<Car, Long> {

    Car findByLp(String lp);

}
