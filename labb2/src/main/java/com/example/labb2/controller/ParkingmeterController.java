package com.example.labb2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.labb2.entity.Parkingmeter;
import com.example.labb2.repository.ParkingmeterRepository;

@RestController
public class ParkingmeterController {

    ParkingmeterRepository parkingmeterRepository;

    public ParkingmeterController(ParkingmeterRepository parkingmeterRepository) {
        this.parkingmeterRepository = parkingmeterRepository;
    }

    @GetMapping("/parkingmeter")
    public List<Parkingmeter> getAllParkingmeters() {
        return (List<Parkingmeter>) parkingmeterRepository.findAll();
    }
}
