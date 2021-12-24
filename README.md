# Wiredcraft Homework
This demo project provides CRUD on the user domain and follows the hexagonal architecture.

## Tech Stack
* Java 11
* MySQL 8.0
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Web 2.6.1](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spock Test Framework](http://spockframework.org/)

## Architecture
Strict dependency relationship: 
- adapter can depend on application
- application can depend on domain
- domain cannot depend on other layers
```
- com
   - wiredcraft
      - homework
         - adapter
         - application
         - domain
```

## Test Strategy
1. E2E test: QA integrates E2E tests with pipeline
2. Integration Test
    1. Contract Test: Pact Test Framework
    2. DB Test: use embedded H2 database to run the DB test
3. Unit Test: Spock Test Framework with groovy
    1. Application Service Layer Test
    2. Domain Service Layer Test
    3. Domain Model Test

## Setup Local Environment
```
bash setup.sh
```
this `setup.sh` script contains following steps: 

1. setup local mysql database
    ```
    docker-compose -f docker/docker-compose.yml up -d
    ```
   the default port of local mysql container is `23306`, if you want to change it, modify the port defined in `docker/docker-compose.yml` and `src/main/resources/application.yml`

2. local build and run tests
    ```
    ./mvnw clean verify
    ```

3. install pre-push git hook (run tests & checkstyle before git push)
    ```
    chmod +x pre-push
    cp pre-push .git/hooks
    ```

## Code Convention
1. Git convention 
   - config username: use Lastname Firstname
   - config email: use company email
    ```
    git config --global user.name 'xxx'
    git config --global user.email 'xxx@xxx.com'
    ```
   - git commit convention: use `[XXX-{ticket number}]` as the prefix of the commit message 
      - valid: [XXX-100] add create order api with tests
      - invalid(no ticket number): [TECH] add strategy time series
      - invalid(meaningless message): [XXX-100] update
   - adopt trunk-based development strategy: use `git pull --rebase` to pull the code from the remote
2. Database convention
   - migration scripts location: `application/src/main/resources/db/migration`
   - migration script name convention: `Vyyyymmddhhmm_description.sql`
   - table name should keep singular: e.g. `task`
3. API design convention
   - follow RESTful api design
   - use `GET`, `POST`, `PUT`, `DELETE` HTTP method
   - use plural to locate the specific resource 
     - valid: GET /users/1
     - valid: POST /users
     - valid: PUT /users/1
     - valid: DELETE /users/1
     - invalid: POST /users/create
     - invalid: POST /users/1/delete

## API Document
See [API DOC](https://github.com/TokenJan/WiredcraftHomework/blob/main/API_DOC.md)

## DevOps
See [DevOps](https://github.com/TokenJan/WiredcraftHomework/blob/main/DevOps.md)
