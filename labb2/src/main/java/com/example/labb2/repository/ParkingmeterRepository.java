package com.example.labb2.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.example.labb2.entity.Parkingmeter;

public interface ParkingmeterRepository extends ListCrudRepository<Parkingmeter, Long> {

    Parkingmeter findById(long id);

    List<Parkingmeter> findByClosed(boolean closed);

}
