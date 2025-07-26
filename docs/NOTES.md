# BSEI RESTful API : fund transfer show case

- Maven 3.9.9 + JDK 21 (current setup on my personal computer)
- Mock service to serve basic GET call with a random exchange-rate
  - implemented using expressjs wrapped with docker
  - <https://expressjs.com/>
- Database preparation: : Docker image, model definition and initialization script
- Using Spring Boot initializer
  - <https://start.spring.io/>
    - Spring Data
    - Spring Data REST
      - REST API for CRUD operations on the different JPA entities (kept for added flexibility under /datarestapi)
      - e.g.: GET /subjects, POST /subjects, GET /subjects/{id}, PUT /subjects/{id}, DELETE /subjects/{id}
      - this will serve in addition to the sql scripts to help with the initialization of the dummy data
      - Relationships (like accounts per subject) are navigable via REST links.
      - JSON representations follow the HAL specification by default.
      - HAL Browser
        - <http://fundtransfer.localhost/datarestapi/explorer/index.html#uri=/datarestapi>
    - Spring REST
      - OpenAPI 3.0 integrated with Swagger UI
      - Api-docs
        - <http://fundtransfer.localhost/api-docs.yaml>
        - <http://fundtransfer.localhost/api-docs>
      - UI
        - <http://fundtransfer.localhost/swagger-ui/index.html>
- Using Lombok for basic boilerplate code
  - <https://projectlombok.org/>
- Using mapstruct for DTO mapping
  - <https://mapstruct.org/>
- Using Ehcache to avoid HTTP request to get the same rate at the same day
  - <https://www.ehcache.org/>
- Basic DTO validation with Spring
- Spring, Mockito, assertj, Rest-Assured and TestContainers for tests
  - <https://site.mockito.org/>
  - <https://rest-assured.io/>
  - <https://assertj.github.io/doc/>
  - <https://testcontainers.com/>
  - Added traefik redirecting port 80 to 8080 of the spring boot app and doing load balancing when scaling is applied
    - <http://localhost:8080/dashboard/#/http/services/fundtransfer@docker>

## Final Remarks

- Tests were added to show-case the strategy and the capability of testing
  - The strategy is basically cover all relevant cyclomatic complexity with unit testing and cover nominal use cases with integration tests
    - to avoid redundancy and overly complex tests

## Useful commands

- deploy the containers ./setup.sh
- scale fund-transfer-service up to 3 nodes ./scale.sh
- [not needed] run backend on console ./mvnw spring-boot:run or mvn spring-boot:run
- [not needed] repackage ./mvnw clean install or mvn clean install
- [not needed] execute on console get to get random exchange rate: curl "<http://localhost:3000/exchange-rate?base=USD&target=EUR>"
  - <https://man7.org/linux/man-pages/man1/curl.1.html>
- access swager ui and using OpenAPI documentation files:  <http://fundtransfer.localhost/swagger-ui/index.html>
  - useful to get curl request templates
- access HAL Browser: <http://fundtransfer.localhost/datarestapi/explorer/index.html#uri=/datarestapi>
  - useful to navigate through the data and also get curl request templates

## potential TODO's to "enrich" this show case

- full test coverage (potentially ignoring negligeable parts)
- integrate HashiCorp Vault or any other solution for sharing secrets
- integrate Liquibase or Flyway
- setup a distributed cache (possible needed if we scale)
- db replication
- integrate db proxy
- deploy local registry see if possible to script tag/push'ing of the images and then transition into swarm or kubernetes
