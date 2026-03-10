# SupportOps Portal

Full-stack incident management application built with **Spring Boot**
and **Angular**.

This project demonstrates a small but complete full-stack architecture
including a REST API backend, validation, filtering, and a connected
Angular frontend UI.

------------------------------------------------------------------------


## Create Incident

![Create Incident](/screenshots/create-incident.jpg)

------------------------------------------------------------------------

# Architecture

The application uses a simple full-stack architecture:

Angular Frontend (UI) \| v Spring Boot REST API \| v Spring Data JPA \|
v H2 Database

-   **Angular** provides the user interface and communicates with the
    backend via HTTP.
-   **Spring Boot** exposes REST endpoints for managing incidents.
-   **Spring Data JPA** handles persistence and database interaction.
-   **H2** is used as an embedded development database.

------------------------------------------------------------------------

# Tech Stack

## Backend

-   Java 21
-   Spring Boot
-   Spring Data JPA
-   Jakarta Validation
-   H2 Database
-   Maven

## Frontend

-   Angular
-   TypeScript
-   Angular HttpClient
-   Angular FormsModule

------------------------------------------------------------------------

# Features

## Backend

-   Incident CRUD REST API
-   DTO-based API architecture
-   Input validation
-   Global exception handling
-   Filtering by status and priority
-   Embedded H2 database persistence

## Frontend

-   Incident dashboard
-   Create incident form
-   Filtering by status and priority
-   Angular service calling REST API

------------------------------------------------------------------------

# API Endpoints

## Health Check

GET /api/health

## Incidents

GET /api/incidents\
GET /api/incidents/{id}

POST /api/incidents\
PUT /api/incidents/{id}\
DELETE /api/incidents/{id}

## Filtering

GET /api/incidents?status=OPEN\
GET /api/incidents?priority=HIGH\
GET /api/incidents?status=OPEN&priority=CRITICAL

------------------------------------------------------------------------

# Project Structure

SupportOps_Portal/ │ ├── supportops-backend/ \# Spring Boot backend │
├── src/ │ └── pom.xml │ ├── supportops-frontend/ \# Angular frontend │
└── supportops-ui/ │ ├── screenshots/ \# UI screenshots used in README │
├── .env.example \# Example environment configuration │ └── README.md

------------------------------------------------------------------------

# Running the Project

## Backend

cd supportops-backend\
./mvnw spring-boot:run

Backend runs on:

http://localhost:8080

------------------------------------------------------------------------

## Frontend

cd supportops-frontend/supportops-ui\
ng serve

Frontend runs on:

http://localhost:4200

------------------------------------------------------------------------

# Database

The project uses an embedded **H2 database** for development.

Data is stored locally in:

supportops-backend/data/supportopsdb.mv.db

You can access the database console at:

http://localhost:8080/h2-console

Connection settings:

JDBC URL: jdbc:h2:file:./data/supportopsdb\
Username: sa\
Password: (empty)

------------------------------------------------------------------------

# Environment Configuration

An example environment configuration file is included:

.env.example

This file demonstrates how configuration such as server ports, database
settings, or API URLs could be externalized using environment variables
in a production environment.

------------------------------------------------------------------------

# Project Goal

The goal of this project is to demonstrate how **Spring Boot and Angular
can be used together to build a simple full-stack incident management
system**.

It showcases:

-   REST API development with Spring Boot
-   Layered backend architecture
-   Angular frontend integration
-   Validation and filtering
-   Full-stack interaction between UI and API

This repository is intended as a **portfolio project** demonstrating
practical full-stack development with Java and Angular.
