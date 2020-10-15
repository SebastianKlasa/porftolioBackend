# Portfolio App

## General information
Portfolio application

### Technologies
- Java 8
- Spring Boot
- JPA
- SQL
- H2 database
- HTML
- CSS
- Javascript

## Setup

### Predefined admin account
To manage to the database you have to predefine admin account. For this purpose modify file: `src\main\java\mycompany\sebastian\portfolioBackend\WebSecurityConfig.java`

### Application properties
There is required to create application.properties file inside directory: `src\main\resources`.
Required format:
```
server.port=<port>

//database settings
spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.datasource.url=jdbc:h2:file:./portfoliodb
spring.h2.console.enabled=true
spring.h2.console.path=/console
spring.h2.console.settings.web-allow-others=true

//gmail account settings
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<username>
spring.mail.password=<password>
spring.mail.protocol=smtp
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
Insert your port, username and password. 

### Compilation and launch

Requirements:
- Maven 3.6.3
- Java 8 or higher <br/>
To build this project locally open project directory and run:
```
mvn package
```
To run program from Command Prompt run follow: 
```
java -jar target/portfolioBackend-0.0.1-SNAPSHOT.jar
```
