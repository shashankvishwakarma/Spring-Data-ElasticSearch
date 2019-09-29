# Spring Data Elastic Search Example
This project depicts the Elastic Search functionality with Spring Data Elastic Search Example.

## Description
This Project loads the list of Users into Elastic and Searches.

## Versions Used
- Spring Boot   -   1.5.2.RELEASE
- elasticsearch -   1.5.2.RELEASE
- Data JPA      -   1.5.2.RELEASE
- H2 Database   -   1.4.193
- Java - 8

## Compilation Command
- `mvn clean install` - Plain maven clean and install

## How to run?
- Run the main class `SpringElasticSearchDemoApplication.java`

## REST API Details -
- `http://localhost:8080/rest/search/name/{name}` - This returns the list of Users for a name.
- `http://localhost:8080/rest/search/salary/{salary}` - This returns the list of Users for the matching salary.
- `http://localhost:8080/rest/search/all` - This returns all Users.
- `http://localhost:8080//rest/manual/search/{text}` - This returns details matching to text.

