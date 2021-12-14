# Wiredcraft Homework
This demo project provides CRUD on the user domain and follows the hexagonal architecture.

key points:
- User is a rich domain model with domain-specific methods encapsulated
- Strict dependency relationship e.g. adapter -> application -> domain

## Tech Stack
* Java 11
* MySQL 8.0
* [Spring Boot 2.6.1](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spock Test Framework](http://spockframework.org/)

### Setup Local Environment
```
bash setup.sh
```

### Api Document
See [API DOC](https://github.com/TokenJan/WiredcraftHomework/blob/main/API_DOC.md)
