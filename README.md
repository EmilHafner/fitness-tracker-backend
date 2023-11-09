# Trackd - Backend API
## Description
This is the backend API for a fitness tracking application. It was built in Java using Spring Boot and Spring Data JPA. 
The code for the frontend application can be found [here](https://github.com/EmilHafner/fitness-tracker-frontend).

## Local Development
To run this application locally, you will need to have Java 20 and Maven installed. You will also need to have a PostgreSQL database running locally on port 8099 (this can be changed in the application.yml file, or by setting command line argument "dbport"). I recommend using Docker to run the database. You can use the following command to run a PostgreSQL database in a Docker container:
```
docker run --env=POSTGRES_PASSWORD=postgres -p 8099:5432 -d postgres:latest
```
Once you have the database running, you can run the application using the following command:
```
mvn spring-boot:run
```
The application will be available at http://localhost:8080.

