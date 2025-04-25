# University Management System (UMS)

A RESTful web application for managing university operations, including user roles (Administrator, Teacher, Student), full CRUD access to entities, and secure API access using Spring Security and JWT.

## How to Run the Project

1. **Prerequisites**:
    - Java 21
    - Maven
    - PostgreSQL (create a database named `ums_db`)

2. **Setup**:
    - Clone the repository: `git clone <repository-url>`
    - Update `src/main/resources/application.yml` with your PostgreSQL credentials.
    - Ensure the JWT secret is a strong 256-bit key.

3. **Run the Application**:
    - Navigate to the project directory: `cd university-management-system`
    - Build and run: `mvn spring-boot:run`

4. **Access the API**:
    - Use tools like Postman or curl to interact with the API.
    - Start with `/auth/register` and `/auth/login` to obtain a JWT token.

## Project Structure Overview

- **config**: Security and application configurations.
- **controller**: REST endpoints for authentication, students, courses, and enrollments.
- **dto**: Data Transfer Objects for API communication.
- **exception**: Custom exceptions and global exception handling.
- **mapper**: Mapping between entities and DTOs using MapStruct.
- **model**: JPA entities (User, Student, Course, Enrollment).
- **repository**: Spring Data JPA repositories.
- **security**: JWT-based authentication and authorization.
- **service**: Business logic with strategy pattern for sorting.

## Example API Endpoints

- **POST /auth/register**: Register a new user (e.g., `{"username":"admin","password":"pass","role":"ADMIN"}`)
- **POST /auth/login**: Login and receive JWT (e.g., `{"username":"admin","password":"pass"}`)
- **POST /students**: Create a student (ADMIN only)
- **GET /courses**: Retrieve all courses (all roles, supports `?sortBy=date` or `?sortBy=students`)
- **POST /enrollments**: Enroll a student in a course (ADMIN, TEACHER)
- **GET /students/{id}**: Get student details (ADMIN)

## Used Technologies

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Flyway
- MapStruct
- Lombok
- JWT

## Build and Run Commands

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run