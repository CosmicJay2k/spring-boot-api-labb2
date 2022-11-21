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

import com.example.labb2.entity.Car;
import com.example.labb2.repository.CarRepository;

@RestController
public class CarController {

    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("/car")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        var myCar = carRepository.save(car);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(myCar.getId())
                .toUri();

        return ResponseEntity.created(location).body(myCar);
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable int id) {
        return carRepository.findById(id);
    }

    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

}
