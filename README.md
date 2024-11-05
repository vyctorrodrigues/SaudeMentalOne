# API de Saúde Mental

Este projeto é uma API RESTful desenvolvida para o monitoramento da saúde mental dos usuários.

## Diagrama UML de Classes

```mermaid
classDiagram
    class User {
        + Long id
        + String name
        + String email
        + String password
    }

    class Goal {
        + Long id
        + String title
        + String description
        + String status
        + User user
    }

    class MoodEntry {
        + Long id
        + Date date
        + String emotion
        + String notes
        + int intensity
        + User user
    }

    User "1" --> "*" Goal
    User "1" --> "*" MoodEntry
