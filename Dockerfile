FROM maven AS build
WORKDIR .
COPY . .
RUN mvn clean package

FROM openjdk:18
WORKDIR /app
COPY --from=build ./target/TestAppV2-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "TestAppV2-0.0.1-SNAPSHOT.jar"]
