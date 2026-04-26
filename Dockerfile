FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY shared ./shared
RUN mvn install -f shared/pom.xml -DskipTests

COPY backend ./backend

RUN mvn package -f backend/pom.xml -DskipTests

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/backend/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]