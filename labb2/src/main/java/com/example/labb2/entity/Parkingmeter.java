package com.example.labb2.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Parkingmeter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Person person;
    @OneToOne
    private Car car;
    @OneToOne
    private Parkingspot parkingspot;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;
    private LocalDateTime end;
    private boolean closed;

    public Parkingmeter() {
    }

    public Parkingmeter(Person person, Car car, Parkingspot parkingspot) {
        this.person = person;
        this.car = car;
        this.parkingspot = parkingspot;
        this.created = LocalDateTime.now();
        this.end = this.created.plusHours(1);
        this.closed = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Parkingspot getParkingspot() {
        return parkingspot;
    }

    public void setParkingspot(Parkingspot parkingspot) {
        this.parkingspot = parkingspot;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getended() {
        return end;
    }

    public void setended(LocalDateTime end) {
        this.end = end;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

}
