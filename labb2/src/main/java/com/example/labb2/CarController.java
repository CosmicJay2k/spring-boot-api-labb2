package com.example.labb2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("/car")
    public String addCar(@RequestBody Car car) {
        carRepository.save(car);
        Person p = new Person();
        p.addCar(car);
        return "Car saved!";
    }

}
