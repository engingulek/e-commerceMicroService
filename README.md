# Microservices E-Commerce Backend

This is a microservices-based backend project for an e-commerce platform. It uses multiple technologies, including Spring Boot, PostgreSQL, MongoDB, and follows a microservices architecture.

This project was used for ecommerceiOSApp <a href="https://github.com/engingulek/ecommerceiOSApp">

## Technologies Used

- **Spring Boot**: Main framework for building the microservices.
- **PostgreSQL**: Used as the primary relational database for most microservices (Product, Category, User, Cart).
- **MongoDB**: NoSQL database used for the Inventory service.
- **API Gateway**: Handles routing between microservices.

## Microservices

### 1. **Product Microservice**
   - **Database**: PostgreSQL
   - **Tech Stack**: Spring Boot, JPA

### 2. **Category Microservice**
   - **Database**: PostgreSQL
   - **Tech Stack**: Spring Boot, JPA

### 3. **User Microservice**
   - **Database**: PostgreSQL
   - **Tech Stack**: Spring Boot, JPA

### 4. **Cart Microservice**
   - **Database**: PostgreSQL
   - **Tech Stack**: Spring Boot, JPA

### 5. **Inventory Microservice**
   - **Database**: MongoDB
   - **Tech Stack**: Spring Boot, Spring Data MongoDB

## API Gateway

API Gateway is implemented to route all incoming HTTP requests to the appropriate microservice. This setup ensures that clients interact with a single entry point, while the gateway routes requests internally to the relevant service.






