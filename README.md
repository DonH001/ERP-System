# ERP System

Enterprise Resource Planning System built with Spring Boot and Oracle Database.

## Features

- Employee Management
- Product Management
- Order Management
- Inventory Management
- Reporting
- REST API endpoints
- Oracle Database integration
- Spring Security implementation

## Setup

1. Install Java 11 or higher
2. Install Maven
3. Install Oracle Database
4. Configure `application.properties` with your database credentials
5. Run `mvn clean install`
6. Start the application with `java -jar target/erp-system-1.0.0.jar`

## API Endpoints

- GET /api/employees - Retrieve all employees
- POST /api/employees - Create new employee
- GET /api/products - Retrieve all products
- POST /api/products - Create new product
- GET /api/orders - Retrieve all orders
- POST /api/orders - Create new order
- GET /api/inventory - Retrieve all inventory items
- POST /api/inventory - Create new inventory item

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Security
- Thymeleaf
- Oracle Database
- Flyway
- Maven
- Bootstrap

## Screenshots

![Dashboard](screenshots/dashboard.png)
![Employee Management](screenshots/employees.png)
![Product Management](screenshots/products.png)
![Order Management](screenshots/orders.png)
![Inventory Management](screenshots/inventory.png)
![Reporting](screenshots/reports.png)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
