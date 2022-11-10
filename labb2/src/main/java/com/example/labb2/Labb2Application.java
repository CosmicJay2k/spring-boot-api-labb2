package com.example.labb2;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Labb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Labb2Application.class, args);
	}
	/*
	 * public void testMethod(PersonRepository person) {
	 * 
	 * ArrayList<Car> cars = new ArrayList<Car>();
	 * 
	 * cars.add(new Car("BMW", "Gullan"));
	 * cars.add(new Car("BMW2", "Gullan2"));
	 * 
	 * person.save(new Person("Guy", "Ritcjie", cars));
	 * 
	 * }
	 */
}
