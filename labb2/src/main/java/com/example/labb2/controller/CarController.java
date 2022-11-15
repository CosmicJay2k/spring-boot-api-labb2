package com.example.labb2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.labb2.entity.Car;
import com.example.labb2.repository.CarRepository;

@RestController
public class CarController {

    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("/car")
    public String addCar(@RequestBody Car car) {
        carRepository.save(car);
        return "Car saved!";
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable int id) {
        return carRepository.findById(id);
    }

    @GetMapping("/car")
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

}
