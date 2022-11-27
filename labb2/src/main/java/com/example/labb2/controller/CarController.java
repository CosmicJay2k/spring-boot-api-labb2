package com.example.labb2.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.labb2.entity.Car;
import com.example.labb2.repository.CarRepository;
import com.example.labb2.repository.PersonRepository;

@RestController
public class CarController {

    CarRepository carRepository;
    PersonRepository personRepository;

    public CarController(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }

    @PostMapping("/api/car")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        var myCar = carRepository.save(car);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(myCar.getLp())
                .toUri();

        return ResponseEntity.created(location).body(myCar);
    }

    @PostMapping(path = "/api/car", params = { "lp", "make", "model", "owner" })
    public ResponseEntity<Car> addCar(@RequestParam String lp, String make, String model, int owner) {

        var myCar = new Car(lp, make, model, personRepository.findById(owner));
        carRepository.save(myCar);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(myCar.getLp())
                .toUri();

        return ResponseEntity.created(location).body(myCar);
    }

    @GetMapping("/api/car/{id}")
    public Car getCarById(@PathVariable String id) {
        return carRepository.findByLp(id);
    }

    @GetMapping("/api/car")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

}
