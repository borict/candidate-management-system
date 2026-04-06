# Candidate Management - Backend

A simple application for managing candidates and their skills.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Maven

## Features

- Create candidate
- Update candidate
- Delete candidate
- Add skills to candidate
- Remove skills from candidate
- Search candidates by full name
- Search candidates by skill

## Running the application

```bash
mvn spring-boot:run
```

## Most interesting part

The most interesting part of the implementation was searching candidates by skill. The search is implemented through a many-to-many relationship between Candidate and Skill entities, allowing filtering candidates based on skill name.
