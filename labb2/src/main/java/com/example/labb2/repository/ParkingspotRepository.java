package com.example.labb2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.example.labb2.entity.Parkingspot;

public interface ParkingspotRepository extends ListCrudRepository<Parkingspot, Long> {
    // ListCrudRepository
    Parkingspot findById(long id);

}
