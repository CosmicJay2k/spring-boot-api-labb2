package com.example.labb2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.labb2.entity.Parkingspot;
import com.example.labb2.repository.ParkingspotRepository;

@RestController
public class ParkingspotController {

    ParkingspotRepository parkingspotRepository;

    public ParkingspotController(ParkingspotRepository parkingspotRepository) {
        this.parkingspotRepository = parkingspotRepository;
    }

    @PostMapping("/parkingspot")
    public String addParkingspot(@RequestBody Parkingspot parkingspot) {
        parkingspotRepository.save(parkingspot);
        return "Parkingspot saved!";
    }

    @GetMapping("/parkingspot/{id}")
    public Parkingspot getParkingspotById(@PathVariable int id) {
        return parkingspotRepository.findById(id);
    }

    @GetMapping("/parkingspot")
    public List<Parkingspot> getAllParkingspots() {
        return parkingspotRepository.findAll();
    }
}
