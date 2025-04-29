# Film API - Bootcamp DIO 🚀
Java RESTful API criada para o Decola Tech 

## Descrição 📖
Este projeto é uma **API de filmes** desenvolvida como parte do **Bootcamp da DIO**.

## Principais Tecnologias
 - **Java 21**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;

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
