# Movie Review API

A RESTful API for managing movies and user authentication built with Spring Boot.

---

## Tech Stack

- Java 25
- Spring Boot 4.0.1
- Spring Security with JWT Authentication
- Spring Data JPA
- H2 Database
- Flyway Migration
- Lombok

## Features

- User registration and login with JWT authentication
- CRUD operations for movies
- Health check endpoint

## API Endpoints

### Authentication

| Method | Endpoint              | Description         |
|--------|-----------------------|---------------------|
| POST   | /api/v1/auth/register | Register a new user |
| POST   | /api/v1/auth/login    | Login and get JWT   |

### Movies

| Method | Endpoint            | Description         |
|--------|---------------------|---------------------|
| GET    | /api/v1/movies      | Get all movies      |
| GET    | /api/v1/movies/{id} | Get movie by ID     |
| POST   | /api/v1/movies      | Create a new movie  |
| PUT    | /api/v1/movies/{id} | Update a movie      |
| DELETE | /api/v1/movies/{id} | Delete a movie      |

## Getting Started

### Prerequisites

- Java 25 or higher
- Gradle

### Running the Application

```bash
./gradlew bootRun
```

### Running Tests

```bash
./gradlew test
```

## Configuration

Application properties can be configured in `src/main/resources/application.properties`.

Key configurations:
- `jwt.secret` - Secret key for JWT token generation
- `jwt.expiration` - JWT token expiration time in milliseconds

---

Made with ❤️ by Darrell