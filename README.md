# Student Management System REST API

A complete REST API built with Spring Boot, MySQL, and JPA for managing student records.

## Features

- Create students
- View all students or a specific student
- Update student details
- Delete students
- Search students by name
- Email and roll number validation
- GPA validation (0-4 scale)

## Tech Stack

- Java 17
- Spring Boot 3.1.5
- Spring Data JPA
- MySQL / H2 Database
- Maven
- Postman (for testing)

## How to Run

1. Clone the repository:
```bash
   git clone https://github.com/YOUR_USERNAME/student-management-system.git
   cd student-management-system
```

2. Update database config in `application.properties` (using H2 by default)

3. Run the application:
```bash
   mvn spring-boot:run
```

4. App runs on `http://localhost:8080/api`

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID |
| GET | /students/search?name=Abhay | Search by name |
| POST | /students | Create new student |
| PUT | /students/{id} | Update student |
| DELETE | /students/{id} | Delete student |

## Sample Request (POST)

```json
{
  "name": "Abhay Chilka",
  "email": "abhay@gmail.com",
  "rollNo": "CS101",
  "gpa": 3.8,
  "dateOfBirth": "2003-12-18"
}
```

## License

MIT