# Laboration Rest API in Spring Boot with MySQL database.

## API mapping:

## /person

POST: String firstName, String lastName
GET: List all

## /person/{id}

GET: Get person with id {id}

## /car

POST: String make, String model, Person owner
GET: List all

## /car/{id}

GET: Get car with id {id}

## /parkingspot

POST: Point<G2D> point, Double price
GET: List all

## /parkingspot/{id}

GET: Get parkingspot with id {id}

## /parkingmeter

POST:
Person person,
Car car,
Parkingspot parkingspot,
LocalDateTime LDT.Now(),
boolean boolean

GET: List all

GET with params (ex: ?closed=false): List all parkingmeters where "closed" is false
