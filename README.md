# SupportOps Portal

Full-stack incident management application built with **Spring Boot** and **Angular**.

## Tech Stack

Backend
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

Frontend
- Angular (planned)

## Features

- Incident CRUD API
- Request validation
- DTO-based API architecture
- Filtering by status and priority
- Global error handling

## API Endpoints

GET /api/incidents  
GET /api/incidents/{id}  
POST /api/incidents  
PUT /api/incidents/{id}  
DELETE /api/incidents/{id}

Filtering:

GET /api/incidents?status=OPEN  
GET /api/incidents?priority=HIGH  

## Running the Backend

```bash
cd supportops-backend
./mvnw spring-boot:run