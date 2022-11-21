# Laboration Rest API in Spring Boot with MySQL database.

## API mapping:

## /person

<p>POST: String firstName, String lastName<br>
GET: List all</p

## /person/{id}

GET: Get person with id {id}

## /car

<p>POST: String make, String model, Person owner<br>
GET: List all</p>

## /car/{id}

GET: Get car with id {id}

## /parkingspot

<p>POST: Point<G2D> point, Double price<br>
GET: List all</p>

## /parkingspot/{id}

GET: Get parkingspot with id {id}

## /parkingmeter

<p>POST:
Person person,
Car car,
Parkingspot parkingspot,
LocalDateTime LDT.Now(),
boolean boolean<br>

GET: List all<br>

GET with params (ex: ?closed=false): List all parkingmeters where "closed" is false</p>
