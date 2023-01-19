## TO CREATE SQL TABLE
```roomsql
CREATE TABLE Users(id int NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(255));
INSERT INTO Users(name) VALUES ('Oscar');
```
## TO ENTER SQL
```bash
mysql -p
```
## NORMAL COMMAND
```bash
docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=Test mysql
```
## If i want my docker to communicate with another container, i have to create a bridge network
```bash
docker run -d -p 3307:3306 --name mysqldb2 --network privet-net -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=Test mysql
docker network create --driver bridge privet-net
```
## Same with the spring server
```bash
docker run -d -p 8080:8080 --network privet-net --name mysql-spring-server spring-mysql-server-app
```

## To access the other container, jdbc change from to
```
spring.datasource.url=jdbc:mysql://localhost:3307/Test?useSSL=false&useUnicode=true&useLegacyDatetimeCode=false?allowPublicKeyRetrieval=true
spring.datasource.url=jdbc:mysql://mysqldb2:3306/Test?useSSL=false&useUnicode=true&useLegacyDatetimeCode=false?allowPublicKeyRetrieval=true
```
#### Where mysqldb2 is the docker container of the mysql
## To create the spring server
```bash
mvn clean package
```
### In Dockerfile
```Dockerfile
FROM openjdk:18
WORKDIR /app
COPY ./target/TestAppV2-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "TestAppV2-0.0.1-SNAPSHOT.jar"]
```
#### Then just build the image as we have done in the other docker project.

# Now i have a docker compose that does all automatically.
```bash
docker-compose up
```
