This is Test Project using Spring boot.
This app use H2 database, JPA, HATEOAS Concept, Swagger for API documentation
H2 Console URL http://localhost:8080/h2-console
Swagger API doc URL http://localhost:8080/v2/api-docs
Actuator Main Links http://localhost:8080/actuator
HATEOAS applied on this URL http://localhost:8080/users/9223372036854775805 (Get user by Id) 

URL Examples:
Get User by ID: GET http://localhost:8080/users/9223372036854775805
Get All users: GET http://localhost:8080/users
Get user posts: GET http://localhost:8080/users/9223372036854775805/posts

Create User: POST -H 'Content-type: application/json' -d '{"name": "Mina AA","birthDate": "2019-10-10T22:00:00.000+00:00"}' http://localhost:8080/users
Create Post: POST -H 'Content-type: application/json' -d '{"message": "my new post created from web service"}' http://localhost:8080/users/9223372036854775805/posts

DB INFORMATION:
DB URL=jdbc:h2:mem:testdb
Username: sa
Password: 

## PREREQUISITE
1.  Operating system Windows or Centos
2.  Java 1.8
3.  IDE eclipse
4.  Maven

## TESTING
Testing the application using Junit
