# Spring Boot Microservices Boilerplate

# 🧠 About

Boilerplate made in course with spring cloud

## 🧪 Technologies

- Java
- Spring Boot
- Spring Cloud
- Config Server
- Discovery Server Eureka
- API Gateway Zuul
- OpenFeign
- Ribbon
- Hystrix
- OAuth
- JWT
- Postgres
- Docker

## 🚀 How to run

```bash
# run docker-compose
$ docker-compose up --build
```

### Connect to postgres database on
- localhost:5432 / postgres:postgres / ms_user
- localhost:5433 / postgres:postgres / ms_worker

execute create.sql and insert data.sql from ms-worker and ms-user

try postman/insomnia on  localhost:8765/ms-oauth/oauth/token

authetication Basic with username "example"(clientId) and password example123(secret) for authorization server
