# QAP 2 — Spring Boot REST API

## Overview

A complete Spring Boot REST API for managing a library of books. This application follows a layered architecture (Model, Repository, Service, Controller) and connects to a MySQL database.

## Technology Stack

- **Framework:** Spring Boot 4.1.0
- **Language:** Java 21
- **Database:** MySQL 9.6
- **Build Tool:** Maven
- **ORM:** Hibernate/JPA
- **Testing:** Postman

## Project Structure

src/main/java/com/example/demo/

├── model/ # Entity classes

│ └── Book.java

├── repository/ # Data access layer

│ └── BookRepository.java

├── service/ # Business logic layer

│ └── BookService.java

├── controller/ # REST API endpoints

│ └── BookController.java

└── DemoApplication.java

## Database Setup

### Prerequisites

- MySQL 9.6+ installed and running
- Maven installed

### Create Database

```bash
mysql -u root
```

Then run:

```sql
CREATE DATABASE books_db;
CREATE USER 'bookuser'@'localhost' IDENTIFIED BY 'bookpassword';
GRANT ALL PRIVILEGES ON books_db.* TO 'bookuser'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

The application will automatically create the `books` table on startup.

## Application Configuration

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/books_db
spring.datasource.username=bookuser
spring.datasource.password=bookpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080
```

## Running the Application

```bash
mvn spring-boot:run
```

The server will start on `http://localhost:8080`

## API Endpoints

All endpoints use the base URL: `http://localhost:8080/api/books`

### 1. GET All Books

- **Method:** GET
- **URL:** `/api/books`
- **Response:** List of all books

### 2. GET Book by ID

- **Method:** GET
- **URL:** `/api/books/{id}`
- **Response:** Single book object

### 3. CREATE New Book

- **Method:** POST
- **URL:** `/api/books`
- **Request Body:**

```json
{
  "title": "Book Title",
  "author": "Author Name",
  "isbn": "ISBN-13",
  "price": 19.99,
  "description": "Book description",
  "yearPublished": 2024
}
```

- **Response:** Created book with generated ID

### 4. UPDATE Book

- **Method:** PUT
- **URL:** `/api/books/{id}`
- **Request Body:** Same as CREATE
- **Response:** Updated book object

### 5. DELETE Book

- **Method:** DELETE
- **URL:** `/api/books/{id}`
- **Response:** 204 No Content

## Testing with Postman

1. Import `BookAPI_Postman_Collection.json` into Postman
2. All 5 endpoints are pre-configured
3. Run requests to test the API

### Sample Book Object

```json
{
  "id": 1,
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "isbn": "978-0743273565",
  "price": 12.99,
  "description": "A classic American novel",
  "yearPublished": 1925
}
```

## Architecture

### Model Layer (Book.java)

- Represents the Book entity
- JPA annotations define database mapping
- Fields: id, title, author, isbn, price, description, yearPublished

### Repository Layer (BookRepository.java)

- Extends JpaRepository for CRUD operations
- Provides methods: save(), findById(), findAll(), deleteById()
- Spring Data JPA handles SQL generation

### Service Layer (BookService.java)

- Contains business logic
- Methods: addBook(), getAllBooks(), getBookById(), updateBook(), deleteBook()
- Dependency injection of BookRepository

### Controller Layer (BookController.java)

- REST endpoints exposed to clients
- Maps HTTP requests to service methods
- Handles request/response conversion
- Returns appropriate HTTP status codes

## Error Handling

- **404 Not Found:** When requesting a book ID that doesn't exist
- **400 Bad Request:** Invalid JSON or missing required fields
- **201 Created:** Successful book creation
- **204 No Content:** Successful deletion

## Building the Project

```bash
mvn clean install
```

## Author

Brandon Coish

## Assignment

QAP 2 — Spring 2026
