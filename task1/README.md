# Spring Boot with PostgreSQL and Docker Compose Example

## STEPS FOR THIS SPRING BOOT APP
- Create a Spring Boot Main @SpringBootApplication
- Create components @Entity / @RestController / @Repository
- Create liquibase settings
- Create application.yml
- Build 
- Check app using curls 

## BUILD the application 
./mvnw clean package

## BUILD AND UP Docker Compose 
docker-compose up --build   
docker-compose down <- down docker compose     

## CURLS 

### POST /user/save 
curl -s -X POST \
  http://localhost:8080/user/save \
  -H 'Content-Type: application/json' \
  -d '{"name":"Your Name"}'


### GET /user/{id}
curl -s -X GET \
  http://localhost:8080/user/1   