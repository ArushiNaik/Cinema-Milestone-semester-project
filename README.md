Cinema Milestone — Full-Stack Application



A complete cinema management platform built with Spring Boot, React + TypeScript, MySQL, and deployed using Render (backend) + Vercel (frontend).



 Table of Contents



Overview



Features



System Architecture



Backend (Spring Boot)



Frontend (React + TypeScript)



API Endpoints



Local Setup



Deployment (Render + Vercel)



Project Structure



Sample Request Bodies



Screenshots (optional section placeholder)



1\. Project Overview



Cinema Milestone is a full-stack web application designed to manage a cinema’s films and screens.

The system supports two main resources:



Films (title, genre, duration, rating, etc.)



Screens (screen number, seats, type, date, linked film)



Users can:



Add, view, edit, delete films



Add, view, edit, delete screens



View film–screen relationships



Search films in real time



Use a clean, paginated UI for management



The aim is to demonstrate solid full-stack engineering using a modern toolchain.



2\. Features

Film Management



Retrieve all films



Retrieve film by ID



Retrieve lightweight summaries



Create film



Update film



Delete film



Search by name (frontend filtering)



Screen Management



Retrieve all screens



Retrieve screen by ID



Create a screen



Update screen



Delete screen



Each screen is mapped One-to-One to a film



Error Handling



Custom FilmNotFoundException



Consistent error response with HTTP 404



Validation on request models



Frontend Features



Fully responsive UI



Sidebar navigation + Header + Footer



Paginated tables



Modal-based Create / Update / Delete



Search Bar with live filtering



Elegant CSS with centralized styling



Error display for invalid inputs



3\. System Architecture

React Frontend (Vercel)

        |

        | REST API Calls

        v

Spring Boot Backend (Render)

        |

        v

MySQL Database (Render / Local)





Backend follows a multi-layer architecture:



PresentationLayer – Controllers \& Request/Response models



BusinessLayer – Service logic



DataAccessLayer – Entities \& JPA repositories



MapLayer – Mapping between entities and DTOs



Exceptions – Custom error handling



4\. Backend — Spring Boot

Technologies



Java 17



Spring Boot



Spring Web



Spring Data JPA



Hibernate



MySQL / H2



Lombok



Gradle



Key Features



Strongly typed DTOs



Validation using @Valid



Film–Screen one-to-one mapping



Clean mapping layer to separate entity logic



Exception management with @ControllerAdvice (if included)



 5. Frontend — React + TypeScript

Technologies



React (Vite)



TypeScript



Axios



Modular components



Custom CSS



Reusable SearchBar component



Paginated tables



Core Components



Header.tsx – Navigation topbar



Footer.tsx – Page footer



Menu.tsx – Sidebar navigation



SearchBar.tsx – Live search input



MainBody.tsx – Page wrapper



ManageFilmsPage.tsx – CRUD for films



ManageScreensPage.tsx – CRUD for screens



api.tsx – Axios service layer



Search Feature Implementation



User types into SearchBar.tsx.



The component sends the text upward via onSearch.



Parent page stores value as searchTerm.



Table filters data instantly:



const filtered = films.filter(f =>

  f.filmName.toLowerCase().includes(searchTerm.toLowerCase())

);



6\. API Endpoints

Film Endpoints

Method	Endpoint	Description

GET	/films	Get all films

GET	/films/{id}	Get film by ID

GET	/films/summaries	Get summarized list

POST	/films	Create film

PUT	/films/{id}	Update film

DELETE	/films/{id}	Delete film

 Screen Endpoints

Method	Endpoint	Description

GET	/screenings	Get all screens

GET	/screenings/{id}	Get screen by ID

POST	/screenings	Create screen

PUT	/screenings/{id}	Update screen

DELETE	/screenings/{id}	Delete screen

GET	/screenings/{id}/films	Get film assigned to a screen

 7. Running Locally

Clone the repository

git clone https://github.com/yourusername/cinema-milestone.git



Backend Setup

Run with Gradle

./gradlew clean build

./gradlew bootRun



Environment Variables

DB\_URL= postgresql://cinemadb\_bvk5\_user:nDWd2I6GTD6YgIV0lo5EstQlc6jAdgKR@dpg-d4niu4fdiees73fl222g-a/cinemadb\_bvk5

DB\_USERNAME= cinemadb\_bvk5\_user

DB\_PASSWORD= nDWd2I6GTD6YgIV0lo5EstQlc6jAdgKR



Frontend Setup

Install dependencies

npm install



Run locally

npm run dev



8\. Deployment

Backend — Render Deployment



Create a new Web Service on Render



Build Command:



./gradlew build





Start Command:



java -jar build/libs/\*.jar



Frontend — Vercel Deployment



Import GitHub project to Vercel



Select Vite → React + TS template



Add environment variable:



VITE\_API\_URL = https://cinema-frontend-ten-omega.vercel.app



Build command:



npm run build





Output directory:



dist



 9. Project Structure

Backend

src/main/java

├── BusinessLayer

│   ├── FilmService.java

│   └── ScreenService.java

├── DataAccessLayer

│   ├── Film.java

│   └── Screen.java

├── MapLayer

│   ├── FilmMapper.java

│   └── ScreenMapper.java

├── PresentationLayer

│   ├── FilmController.java

│   ├── FilmRequestModel.java

│   ├── FilmResponseModel.java

│   ├── FilmSummary.java

│   ├── ScreenController.java

│   ├── ScreenRequestModel.java

│   ├── ScreenResponseModel.java

│   └── ScreenSummary.java

└── Exceptions

    └── FilmNotFoundException.java



Frontend

src

├── components

│   ├── Header.tsx

│   ├── Footer.tsx

│   ├── Menu.tsx

│   ├── SearchBar.tsx

│   └── MainBody.tsx

├── pages

│   ├── HomePage.tsx

│   ├── AboutPage.tsx

│   ├── ManageFilmsPage.tsx

│   └── ManageScreensPage.tsx

├── services

│   ├── api.tsx

│   └── types.tsx

├── models

│   ├── models.tsx

│

├── App.tsx

└── App.css



10\. Sample JSON

Film

{

  "filmName": "Inception",

  "filmGenre": "Sci-Fi",

  "filmDuration": 148,

  "filmLanguage": "English",

  "filmRating": 8.8,

  "filmDescription": "A mind-bending thriller by Christopher Nolan."

}



Screen

{

  "screenNum": 3,

  "availableSeats": 100,

  "screenType": "IMAX",

  "screenDate": "2025-05-01",

  "screenDescription": "Premium IMAX experience",

  "filmId": 1

}





GitHub link for the frontend: https://github.com/Agnesa24/cinemaFrontend.git

GitHub link for the backend: https://github.com/Agnesa24/CinemaMilestone.git

