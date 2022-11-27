# Laboration Rest API in Spring Boot with MySQL database.

_Run MySql on port 3307, with a database named "test"._

## API endpoints:

## /api/person

<p>POST: String firstName, String lastName as JSON body<br>
  
GET: List all</p>

## /api/person/{id}

GET: Get view containing first and last name of person with id {id}

## /api/person/{id}/full

GET: Get person with id {id}

## /api/car

<p>POST: String lp, String make, String model, Person owner as JSON body<br>

POST with params<br>
(?lp={string}&make={string}&model={string}&owner={id})<br>

GET: List all</p>

## /api/car/{id}

GET: Get car with id {id}

## /api/parkingspot

<p>POST: Point<G2D> point, Double price as JSON body<br>

POST with params<br>
(?c1={double}&c2={double}): c1 and c2 are coordinates<br>

GET: List all</p>

## /api/parkingspot/{id}

GET: Get parkingspot with id {id}

## /api/parkingmeter

<p>POST:
Person person,
Car car,
Parkingspot parkingspot as JSON body<br>

POST with params<br>
(?car={licensePlate}&parkingspot={id})<br>

GET: List all<br>

GET with params<br>
(?closed={boolean}): List all parkingmeters where "closed" is {boolean}<br>
(?closed={boolean}&person={id}): List all parkingmeters where "closed" is {boolean} and "person" is {id}<br>
(?closed={boolean}&car={id}: List all parkingmeters where "closed" is {boolean} and "car" is {id}</p>

## /api/parkingmeter/{id}

<p>GET: Get parkingmeter with id {id}<br>

PATCH: Update end time of parkingmeter with {id}</p>

## /api/parkingmeter/{id}/close

PATCH: Close parkingmeter with {id}<br>
<br>
<br>

_Inlämningsuppgift 2 -- SJPI21 -- John Tannenberg_
