# Stage 1: Build the JAR
FROM eclipse-temurin:17-jdk-focal AS build
WORKDIR /app

# Copy Maven wrapper and pom.xml, then download dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copy the source code and build the JAR
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Stage 2: Create a smaller runtime image
FROM eclipse-temurin:17-jre-focal
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar kubesTest.jar

# Expose port 8080 and run the app
EXPOSE 8080
CMD ["java", "-jar", "kubesTest.jar"]
