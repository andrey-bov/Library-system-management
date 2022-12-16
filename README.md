# Library Management System

 training project using the Spring cloud
    
## Technology Stack & Frameworks
> `Java 8` `Spring-Boot-2.3.2.RELEASE` `Spring-Cloud` `Spring Data JPA` `Docker` `Docker-Compose` `JUnit 5` `gradle` `PostgreSQL` 

## Installation and Running
- **With Docker and Docker Compose Installed**
```docker
docker compose down
docker compose build
docker compose up
-------------------------
or run the start.sh file
-------------------------
```
## Scheme 
 ![User- Search Orders](https://github.com/andrey-bov/Library-system-management/blob/master/scheme/scheme.png)
## Ports Exposed
Application | Port 
----------- | ---- 
*config* | `8001`
*registry* | `8761`
*gateway* | `8989`
*notification* | `9999`
*user-service* | `8081`
*book-service* | `8082`
*order-service* | `9998`

## functionality
* add , delete , update Book and User
* create , delete Order
