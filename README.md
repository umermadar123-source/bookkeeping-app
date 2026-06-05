# Bookkeeping App

An online bookkeeping, inventory management, and sales receipt application built with Spring Boot and Java.

## How It Works

This app is a comprehensive bookkeeping solution designed to help businesses manage their finances, track inventory, and generate sales receipts efficiently.

### Architecture

The application follows a three-tier architecture:

1. **Presentation Layer** - REST APIs powered by Spring Boot Web
2. **Business Logic Layer** - Service layer for core operations
3. **Data Access Layer** - Spring Data JPA for database operations

### Technology Stack

- **Backend Framework**: Spring Boot 3.1.5
- **Language**: Java 17
- **Database**: H2 (configurable for MySQL/PostgreSQL)
- **ORM**: Spring Data JPA
- **Build Tool**: Maven
- **Code Generation**: Lombok

### Core Features

- 📊 **Online Bookkeeping** - Record and manage financial transactions
- 📦 **Inventory Management** - Track stock levels and item details
- 🧾 **Sales Receipts** - Generate and manage sales receipts

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Installation

1. Clone the repository:
```bash
git clone https://github.com/umermadar123-source/bookkeeping-app.git
cd bookkeeping-app
```

2. Build the application:
```bash
mvn clean package
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Project Structure

```
bookkeeping-app/
├── src/main/
│   ├── java/
│   │   └── com/bookkeeping/
│   └── resources/
├── pom.xml
└── README.md
```

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- H2 Database
- Lombok
- Jackson (JSON processing)
- Spring Boot Test

## License

This project is open source and available under the MIT License.

## Support

For issues, questions, or contributions, please visit the [GitHub Issues](https://github.com/umermadar123-source/bookkeeping-app/issues) page.
