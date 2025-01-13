# Step 1: Build the Spring Boot application using Maven
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .

# Download dependencies (to leverage Docker caching)
RUN mvn dependency:go-offline

# Copy the entire source code
COPY src ./src

# COPY docker-entrypoint.sh /app/docker-entrypoint.sh
COPY docker-entrypoint.sh .
RUN chmod +x /app/docker-entrypoint.sh

# Build the Spring Boot application
RUN mvn clean package -DskipTests

# Step 2: Create the runtime image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

COPY docker-entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-entrypoint.sh


# Expose the port the application will run on
# EXPOSE 8081

# Set the entrypoint
ENTRYPOINT ["docker-entrypoint.sh"]

# Default command
CMD ["java", "-jar", "app.jar"]
