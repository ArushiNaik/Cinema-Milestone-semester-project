# Cinema Milestone 🎬

**Java 17 · Spring Boot 3.5 · Spring Data JPA · Gradle**

Behind the scenes of a cinema management API: a layered backend for films and screens, with request/response models, services, mapping and persistence.

[Portfolio](https://github.com/ArushiNaik) · [Browse source](https://github.com/ArushiNaik/Cinema-Milestone-semester-project)

## What to explore

- Film and screen CRUD controller flows.
- Film summaries and film–screen relationships.
- DTO mapping and persistence.
- Validation and custom exception handling.

## A guide to the code

- `src/main/java/org/example/cinemamilestone/PresentationLayer` — controllers and DTOs
- `src/main/java/org/example/cinemamilestone/BusinessLayer` — services
- `src/main/java/org/example/cinemamilestone/DataAccessLayer` — entities and repositories
- `build.gradle` — dependencies

## Run locally

Install Java 17. Review `src/main/resources` for database configuration and supply local settings through environment variables or an untracked local profile.

```bash
./gradlew bootRun
```

Windows: `gradlew.bat bootRun`. Build with `./gradlew build`; test with `./gradlew test`.

Use the root Gradle project. `CinemaMilestone-master/` is an additional source copy, not a second required service.

## Project notes

The earlier README described a separate React frontend. This checkout contains the Java backend, so frontend build instructions are not asserted here. Gradle includes PostgreSQL, MariaDB and H2 drivers; active configuration determines which database is needed. Actual connection credentials belong outside Git. Startup and hosting availability have not been revalidated.

## Context

A project in [Arushi Naik’s portfolio](https://github.com/ArushiNaik).
