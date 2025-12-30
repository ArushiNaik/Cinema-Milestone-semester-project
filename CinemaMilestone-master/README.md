Cinema Milestone Project
Project Overview

This project is a Spring Boot application for managing a cinema’s films and screens. It allows you to:

Add, retrieve, update, and delete films

View brief summaries of films

Manage screens showing specific films (one-to-one relationship)

Handle errors gracefully with custom exceptions

Features
Film Management

GET /films – Retrieve all films

GET /films/{id} – Retrieve a film by ID

GET /films/summaries – Retrieve a brief summary of all films

POST /films – Add a new film

PUT /films/{id} – Update an existing film

DELETE /films/{id} – Delete a film by ID

Screen Management (Optional)

Each screen is mapped to one film (@OneToOne relationship).

Screens have attributes like: screen number, available seats, type, date, and description.

Error Handling

Custom exception: FilmNotFoundException

Returns HTTP 404 when a film is not found

Technologies Used

Java 17

Spring Boot

Spring Data JPA (Hibernate)

Lombok

H2 / MySQL (configurable)

gradle

Project Structure
src/main/java
├── DataAccessLayer
│   ├── Film.java
│   └── Screen.java
├── BusinessLayer
│   └── FilmService.java
        ScreenService.java
├── MapLayer
│   └── FilmMapper.java
        ScreenMapper.java
├── PresentationLayer
│   ├── FilmController.java
│   ├── FilmRequestModel.java
│   ├── FilmResponseModel.java
│   └── FilmSummary.java
│   ├── ScreenController.java
│   ├── ScreenRequestModel.java
│   ├── ScreenResponseModel.java
│   └── ScreenSummary.java
└── Exceptions
    └── FilmNotFoundException.java
    └── FilmNotFoundException.java
    

Usage

Clone the repository:

git clone https://github.com/yourusername/cinema-milestone.git


Build and run with Gradle:

 clean install
 spring-boot:run


Use Postman or any HTTP client to interact with endpoints.

Sample JSON for adding/updating a film:

{
  "filmName": "Inception",
  "filmGenre": "Sci-Fi",
  "filmDuration": 148,
  "filmLanguage": "English",
  "filmRating": 8.8,
  "filmDescription": "A mind-bending thriller by Christopher Nolan."
}
