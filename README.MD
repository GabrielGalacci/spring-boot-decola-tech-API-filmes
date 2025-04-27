# Film API - Bootcamp DIO 🚀
Java RESTful API criada para o Decola Tech 

## Descrição 📖
Este projeto é uma **API de filmes** desenvolvida como parte do **Bootcamp da DIO**.  

## Diagrama de Classes
```mermaid
classDiagram
    class Film {
        -String name
        -String genre
        -Date releaseYear
        -Integer lengthMinutes
        -String parentalRating
        -Integer rating
        -ProductionCompany productionCompany
        -Person producer
        -Person[] cast
    }

    class ProductionCompany {
        -String name
        -Date foundationDate
        -String headquartersState
        -String headquartersCountry
    }

    class Person {
        -String fullName
        -String aka
        -Integer age
        -Date birthDate
        -String birthplaceState
        -String birthplaceCountry
    }

    Film "1" --> "1" ProductionCompany : producedBy
    Film "1" --> "1" Person : producedBy (Producer)
    Film "1" --> "*" Person : castMembers
```
