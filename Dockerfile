# (1) Use a Java 21 JDK as the builder image
FROM eclipse-temurin:21-jdk AS builder

# (2) Create an app directory inside the container
WORKDIR /app

# (3) Copy the entire project into the container
COPY . .

# (4) Build the project
RUN ./mvnw clean package -DskipTests

# (5) We now create a “runtime” container using a minimal JRE 21 base image
FROM eclipse-temurin:21-jre

# (6) Create a directory for our final app
WORKDIR /app

# (7) Copy the compiled Spring Boot JAR from the builder stage into this container.
COPY --from=builder /app/cft-container/target/cft-container-0.0.1-SNAPSHOT.jar app.jar

# (8) Expose port 8080, adjust if your app runs on a different port
EXPOSE 8080

# (9) Default command to run your Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]