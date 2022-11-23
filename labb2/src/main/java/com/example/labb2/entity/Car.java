package com.example.labb2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {

    @Id
    @Column(unique = true, nullable = false)
    private String lp;
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long lp;
    private String make;
    private String model;
    @ManyToOne
    private Person owner;

    protected Car() {
    }

    public Car(String lp, String make, String model, Person owner) {
        this.lp = lp;
        this.make = make;
        this.model = model;
        this.owner = owner;
    }

    public String getLp() {
        return lp;
    }

    public void setLp(String lp) {
        this.lp = lp;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
