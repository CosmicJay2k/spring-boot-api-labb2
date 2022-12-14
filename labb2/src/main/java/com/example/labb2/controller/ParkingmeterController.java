package com.example.labb2.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.labb2.entity.Parkingmeter;
import com.example.labb2.exception.CustomException;
import com.example.labb2.repository.CarRepository;
import com.example.labb2.repository.ParkingmeterRepository;
import com.example.labb2.repository.ParkingspotRepository;
import com.example.labb2.repository.PersonRepository;

import jakarta.transaction.Transactional;

@RestController
public class ParkingmeterController {

    ParkingmeterRepository parkingmeterRepository;
    PersonRepository personRepository;
    CarRepository carRepository;
    ParkingspotRepository parkingspotRepository;

    public ParkingmeterController(ParkingmeterRepository parkingmeterRepository, PersonRepository personRepository,
            CarRepository carRepository, ParkingspotRepository parkingspotRepository) {
        this.parkingmeterRepository = parkingmeterRepository;
        this.personRepository = personRepository;
        this.carRepository = carRepository;
        this.parkingspotRepository = parkingspotRepository;
    }

    @PostMapping("/api/parkingmeter")
    public ResponseEntity<Parkingmeter> addParkingmeter(@RequestBody Parkingmeter parkingmeter) {
        var myParkingmeter = parkingmeterRepository.save(parkingmeter);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(myParkingmeter.getId())
                .toUri();

        return ResponseEntity.created(location).body(myParkingmeter);
    }

    @PostMapping(path = "/api/parkingmeter", params = { "car", "parkingspot" })
    public ResponseEntity<Parkingmeter> addParkingmeterParams(@RequestParam String car, Long parkingspot) {
        var myParkingmeter = new Parkingmeter();
        try {
            myParkingmeter = new Parkingmeter(carRepository.findOwnerIdByLp(car).getOwner(),
                    carRepository.findByLp(car),
                    parkingspotRepository.findById(parkingspot).get());
            parkingmeterRepository.save(myParkingmeter);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(myParkingmeter.getId())
                    .toUri();

            return ResponseEntity.created(location).body(myParkingmeter);
        } catch (NoSuchElementException e) {
            throw new CustomException("Missing parkingspot");
        } catch (Exception e) {
            throw new CustomException("Missing car");
        }
    }

    @Transactional
    @PatchMapping("/api/parkingmeter/{id}")
    public ResponseEntity<?> updateParkingmeterEnd(@PathVariable Long id) {
        LocalDateTime endTimeBefore = parkingmeterRepository.findById(id).get().getEnd();
        parkingmeterRepository.updateEnd(id, endTimeBefore.plusHours(1));
        return ResponseEntity.ok("Added one hour");
    }

    @Transactional
    @PatchMapping("/api/parkingmeter/{id}/close")
    public ResponseEntity<?> closeParkingmeter(@PathVariable Long id) {
        parkingmeterRepository.closeParkingmeter(id);
        return ResponseEntity.ok("Closed parkingmeter");
    }

    @GetMapping("/api/parkingmeter/{id}")
    public Parkingmeter getParkingmeterById(@PathVariable Long id) {
        return parkingmeterRepository.findById(id).get();
    }

    @GetMapping("/api/parkingmeter")
    public List<Parkingmeter> getAllParkingmeters() {
        return parkingmeterRepository.findAll();
    }

    @GetMapping(path = "/api/parkingmeter", params = "closed")
    public List<Parkingmeter> getParkingmetersByOpenOrClosed(@RequestParam boolean closed) {
        return parkingmeterRepository.findByClosed(closed);
    }

    @GetMapping(path = "/api/parkingmeter", params = { "closed", "person" })
    public List<Parkingmeter> getParkingmetersByClosedAndPerson(@RequestParam boolean closed,
            @RequestParam int person) {
        return parkingmeterRepository.findByClosedAndPerson_id(closed, person);
    }

    @GetMapping(path = "/api/parkingmeter", params = { "closed", "car" })
    public List<Parkingmeter> getParkingmetersByClosedAndCar(@RequestParam boolean closed, @RequestParam String car) {
        return parkingmeterRepository.findByClosedAndCar_lp(closed, car);
    }
}
