package com.example.labb2;

import java.time.LocalDateTime;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;
import static org.geolatte.geom.builder.DSL.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.labb2.entity.Car;
import com.example.labb2.entity.Parkingmeter;
import com.example.labb2.entity.Parkingspot;
import com.example.labb2.entity.Person;
import com.example.labb2.repository.CarRepository;
import com.example.labb2.repository.ParkingmeterRepository;
import com.example.labb2.repository.ParkingspotRepository;
import com.example.labb2.repository.PersonRepository;

@SpringBootApplication
public class Labb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Labb2Application.class, args);
	}

	@Bean
	CommandLineRunner init(PersonRepository person, CarRepository car, ParkingspotRepository parking,
			ParkingmeterRepository meter) {
		return (args) -> {
			var p1 = new Person("Bob", "Namnson");
			person.save(p1);
			var c1 = new Car("BMW", "Caar", p1);
			car.save(c1);
			Point<G2D> point = new Point<G2D>(point(WGS84, g(4.33, 3.21)));
			var ps = new Parkingspot(point, 12.23);
			parking.save(ps);
			var pm = new Parkingmeter(p1, c1, ps, LocalDateTime.now(), false);
			meter.save(pm);
		};
	}
}
