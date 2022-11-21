package com.example.labb2.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.labb2.entity.Parkingmeter;
import com.example.labb2.repository.ParkingmeterRepository;

@RestController
public class ParkingmeterController {

    ParkingmeterRepository parkingmeterRepository;

    public ParkingmeterController(ParkingmeterRepository parkingmeterRepository) {
        this.parkingmeterRepository = parkingmeterRepository;
    }

    @PostMapping("/parkingmeter")
    public ResponseEntity<Parkingmeter> addParkingmeter(@RequestBody Parkingmeter parkingmeter) {
        var myParkingmeter = parkingmeterRepository.save(parkingmeter);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(myParkingmeter.getId())
                .toUri();

        return ResponseEntity.created(location).body(myParkingmeter);
    }

    @GetMapping("/parkingmeter")
    public List<Parkingmeter> getAllParkingmeters() {
        return parkingmeterRepository.findAll();
    }

    @GetMapping(path = "/parkingmeter", params = "closed")
    public List<Parkingmeter> getParkingmetersByOpenOrClosed(@RequestParam boolean closed) {
        return parkingmeterRepository.findByClosed(closed);
    }
}
