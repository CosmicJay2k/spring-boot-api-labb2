# Laboration Rest API in Spring Boot with MySQL database.

## API endpoints:

## /person

<p>POST: String firstName, String lastName<br>
  
GET: List all</p>

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
Parkingspot parkingspot<br>

GET: List all<br>

GET with params<br>
(?closed={boolean}): List all parkingmeters where "closed" is {boolean}<br>
(?closed={boolean}&person={id}): List all parkingmeters where "closed" is {boolean} and "person" is {id}<br>
(?closed={boolean}&car={id}: List all parkingmeters where "closed" is {boolean} and "car" is {id}</p>

## /parkingmeter/{id}

<p>GET: Get parkingmeter with id {id}<br>

PATCH: Update end time of parkingmeter with {id}<p>
