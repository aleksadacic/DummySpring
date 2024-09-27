
# DummySpring Project

## Overview

**DummySpring** is an experimental Spring Boot project designed for testing and experimentation purposes. The project currently works with a PostgreSQL database, but it can easily be extended to work with other relational databases. This project provides a basic API and can be further extended to include additional libraries or frameworks for testing and integration purposes.

This project is meant to serve as a sandbox for experimenting with various Spring Boot features, database interactions, and the integration of third-party libraries. It is highly flexible, allowing users to add new dependencies and extend the functionality as required.

## Features

- Basic API with versioned endpoints (e.g., `/api/`)
- Pre-configured for PostgreSQL but adaptable for other relational databases
- Environment variable support for securing sensitive information
- A `sample` configuration file (`application-sample.properties`) is included for easy setup
- Easily extendable to test various libraries, APIs, and dependencies

## Requirements

- Java 21 or higher
- Maven 3 or higher
- PostgreSQL (default configuration for this project)

## Setup

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/DummySpring.git
cd DummySpring
```

### 2. Configure the Environment

This project relies on environment variables for sensitive configuration details like database credentials. To configure these:

1. Create an `application.properties` file in the resources directory of the project:

2. Change the following lines in your `application.properties` file and adjust them as necessary:

   ```bash
   spring.datasource.url=${DB_URL}
   spring.datasource.username=${DB_USERNAME}
   spring.datasource.password=${DB_PASSWORD}
   ```

### 3. Database Configuration

By default, the project is configured to work with PostgreSQL. However, you can adapt the project to work with other relational databases (e.g., MySQL, MariaDB) by changing the `spring.datasource.url`, `spring.datasource.driver-class-name`, and `spring.jpa.properties.hibernate.dialect` in the `application.properties` (or use a different database dialect if needed).

#### To switch to MySQL, for example:

1. Change the dialect:

   ```properties
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```

2. Update the database URL and driver class:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   ```

### 4. Add Your Own Libraries

DummySpring is designed to allow easy integration of additional libraries. To include a new library:

1. Add the dependency to the `pom.xml` file.
2. Define any required configuration.
3. Build and test the project with the new library.

For example, if you want to test out **Lombok**:

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.20</version>
    <scope>provided</scope>
</dependency>
```

Once added, Lombok annotations such as `@Getter`, `@Setter`, and `@Builder` will be available for use.

### 5. Running the Project

Once the project is set up, you can run it using Maven:

```bash
mvn spring-boot:run
```

This will start the Spring Boot application and serve the API at `http://localhost:8080/api`.

## API Endpoints

Currently, the project provides a basic API that can be extended to meet your requirements. Below is a sample list of endpoints:

- **GET** `/api/users` - Retrieve all users
- **GET** `/api/users/{id}` - Retrieve a user by ID
- **POST** `/api/users` - Create a new user

You can modify and extend these endpoints as necessary for your experiments.

## Extending the Project

DummySpring is designed to be a starting point for testing:

1. **Add Additional Libraries**: Easily include new dependencies in the `pom.xml` file to integrate other technologies or frameworks.
2. **Switch Databases**: Modify the database configuration in the `application.properties` file or use environment variables to switch between different relational databases.
3. **Test APIs**: The API structure provided can be extended to include more complex operations, such as interacting with different microservices, external APIs, or new libraries.

Feel free to fork this repository and use it as a sandbox for experimenting with Spring Boot features, database interactions, and third-party integrations.

## Contributing

Contributions are welcome! If you have any ideas, improvements, or bug fixes, feel free to open an issue or submit a pull request.

## License

This project is open-source under the [MIT License](LICENSE). Feel free to use, modify, and distribute it as per the terms of the license.

## Contact

For any questions, feel free to reach out via the repository or email.
