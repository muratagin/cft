# **Carbon Footprint Tracker (CFT)**

A sample **Domain-Driven Design** (DDD) & **Clean Architecture** Spring Boot application for tracking carbon emissions based on user activities. This project is organized into multiple modules and showcases how to structure a Spring Boot application by separating domain logic from application services, infrastructure, and presentation layers. Best practices like Clean Architecture, Ports & Adapters, and CQRS are also implemented.

---

## **Features**

- **User** entity: Stores user info (UUID primary key, name, email, registration date).
- **Activity Type** entity: Reference data about different activity categories (e.g., “Car Commute,” “Flight,” etc.).
- **Activity** entity: Logs a user’s real-world activity, including an estimated carbon emission.

---

## **Tech Stack**

- **Java 21**
- **Spring Boot**
- **PostgreSQL 15**
- **Maven (multi-module)**
- **Docker & Docker Compose**

---

## **Project Structure**

```
cft/
├── cft-container
│   ├── src/main/java/com.jugtechday.cft.container
│   │   └── CftContainerApplication.java
│   ├── src/main/resources/application.yml  (server.port=8080)
│   └── pom.xml
├── cft-domain
│   ├── cft-domain-core
│   ├── cft-application-service
│   └── pom.xml
├── cft-infrastructure
│   ├── cft-persistence
│   │   ├── src/main/java/com.jugtechday.cft.infrastructure.persistence/…
│   │   └── pom.xml
│   └── pom.xml
├── cft-presentation
│   ├── src/main/java/com.jugtechday.cft.presentation
│   │   └── rest/ActivityController.java
│   └── pom.xml
├── docker-compose.yml
├── init-db.sql
├── Dockerfile
├── requests/        (folder containing .http files for sample requests)
└── pom.xml
```

- **`cft-container`**: Main Spring Boot launcher & global configuration (including `application.yml` on port **8080**).
- **`cft-presentation`**: REST controllers, endpoints, request/response models.
- **`cft-domain`**: Core domain logic, entities, domain services.
- **`cft-infrastructure`**: Database adapters, repository implementations, etc.

---

## **Getting Started**

### **Prerequisites**

- **Docker** and **Docker Compose** installed

### **1. Clone or Download the Repository**

```bash
git clone https://github.com/muratagin/cft.git
cd cft
```

### **2. Run with Docker Compose**

From the root of the project, run:
```bash
docker-compose up --build
```
- **Postgres** container (named cft-postgres) starts, creates the cftdb database, and seeds it using init-db.sql.
- **Spring Boot** container (named cft-app) starts on **port 8080**.

The first run may take a while as Docker pulls images and compiles the application.

### **3. Verify It’s Running (Sample Endpoints)**

Sample .http request files are located under the **requests/** folder. You can open these in IntelliJ or VS Code to quickly send test requests.

- ***createActivityCommand.http*** : **POST /activities** – creates a new activity.
- ***getByIdActivityQuery.http*** : **GET /activities/{id}** – returns activity with id if exists.

### **4. Container Lifecycle**

- **To stop** :
```bash
docker-compose down
```
This stops all containers.

- **To remove** the volumes (i.e., reset the database) :
```bash
docker-compose down -v
```
Next time you run docker-compose up, it re-initializes the database using init-db.sql.

---

## **Configuration Notes**

- **Database Credentials** in docker-compose.yml:

```
POSTGRES_USER: cft
POSTGRES_PASSWORD: cftpass
POSTGRES_DB: cftdb
```

- **application.yml** (in cft-container):

```
spring:
  datasource:
    url: jdbc:postgresql://db:5432/cftdb
    username: cft
    password: cftpass
  jpa:
    hibernate:
      ddl-auto: update
```

- **init-db.sql** sets up UUID‐based tables and inserts sample data.

---

## **License**

This project is licensed under the [Apache License Version 2.0](https://www.apache.org/licenses/LICENSE-2.0).

---

## **Contributing**

Pull requests or issues are welcome. This project’s primary purpose is to demonstrate **DDD** principles and containerized deployment with **Spring Boot** and **PostgreSQL**.

