# solve-r-us
A boilerplate application built to solve issues related to Java/Spring Boot/Javascript/React/Angular

## Software
* Maven: to download dependencies from Spring and MySQL.
* JDK (Java Development Kit) /OpenJDK: environment needed to build our application.
* XXAMP (Cross-platform, Apache, MySQL, PHP and Perl): to run your MySQL database.
* NPM (Node Package Manager): to manage software libraries and build artifacts used in our frontend application.  
* Postman: to make requests to the defined endpoints.
* DBeaver: Database Manager to run queries in.  

## Database
solve-r-us-mysql-db

## Tables
You can find the Data Definition Language (DDL) statements in the solve-r-us\database\ddl folder.
artist
album
customer
employee
genre
invoice
invoiceline
mediatype
playlist
playlisttrack
track

## Data
The Data Manipulation Language (DML) statements are found in the solve-r-us\database\dml folder. You must insert the data considering the constraints and foreign keys.

## Endpoints
### Customer
http://localhost:8080/customers

### Track
http://localhost:8080/tracks

