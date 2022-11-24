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

import com.example.labb2.entity.Parkingspot;
import com.example.labb2.repository.ParkingspotRepository;

@RestController
public class ParkingspotController {

    ParkingspotRepository parkingspotRepository;

    public ParkingspotController(ParkingspotRepository parkingspotRepository) {
        this.parkingspotRepository = parkingspotRepository;
    }

    @PostMapping("/api/parkingspot")
    public ResponseEntity<Parkingspot> addParkingspot(@RequestBody Parkingspot parkingspot) {
        var myParkingspot = parkingspotRepository.save(parkingspot);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(myParkingspot.getId())
                .toUri();

        return ResponseEntity.created(location).body(myParkingspot);
    }

    @GetMapping("/api/parkingspot/{id}")
    public Parkingspot getParkingspotById(@PathVariable int id) {
        return parkingspotRepository.findById(id);
    }

    @GetMapping("/api/parkingspot")
    public List<Parkingspot> getAllParkingspots() {
        return parkingspotRepository.findAll();
    }
}
