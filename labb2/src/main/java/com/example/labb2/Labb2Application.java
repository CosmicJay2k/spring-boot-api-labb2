package com.example.labb2;

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

	// DEV population of the database
	@Bean
	CommandLineRunner init(PersonRepository person, CarRepository car, ParkingspotRepository parking,
			ParkingmeterRepository meter) {
		return (args) -> {
			var p1 = new Person("Bob", "Namnson");
			person.save(p1);
			var p2 = new Person("Bob2", "Namnson");
			person.save(p2);
			var c1 = new Car("ATL213", "BMW", "Caar", p2);
			car.save(c1);
			var c2 = new Car("OST555", "BMW Ultra", "Felino", p1);
			car.save(c2);
			Point<G2D> point = new Point<G2D>(point(WGS84, g(4.33, 3.21)));
			var ps = new Parkingspot(point, 12.23);
			parking.save(ps);
			Point<G2D> point2 = new Point<G2D>(point(WGS84, g(4.34, 3.22)));
			var ps2 = new Parkingspot(point2, 12.23);
			parking.save(ps2);
			var pm = new Parkingmeter(p1, c2, ps);
			meter.save(pm);
			var pmClosed = new Parkingmeter(p2, c1, ps2);
			meter.save(pmClosed);
		};
	}
}
