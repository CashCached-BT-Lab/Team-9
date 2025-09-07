# Customer Audit Service (MySQL)

Backend-only Spring Boot service for Zenith Bank to manage `AUDIT_LOG` and unified `CUSTOMER_PROFILE` with audit JSON.

## Prerequisites
- Java 17+
- Maven 3.9+
- MySQL 8.x running locally

## Configure
Edit `src/main/resources/application.yml`:
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/zenith_customer?createDatabaseIfNotExist=true
    username: root
    password: root
```

## Run
```
mvn spring-boot:run
```
Flyway will create tables on startup.

## API
- POST `/api/audits`
- GET `/api/audits`
- GET `/api/audits/{id}`
- POST `/api/customers`
- GET `/api/customers`
- GET `/api/customers/{id}`

`CHANGED_FIELDS` and `AUDIT_DETAILS` are JSON columns (as text payloads from API).



