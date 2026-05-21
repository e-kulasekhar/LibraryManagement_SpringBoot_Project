# Library Management API

## 📌 Overview
The Library Management API is a Spring Boot backend application designed to efficiently manage library operations such as book management, user management, and book issue/return tracking. It provides RESTful APIs for performing CRUD operations and ensures proper handling of library rules and data consistency.

This project is designed to simulate a real-world library system backend.

---

## 🚀 Features
- Add, update, delete, and view books
- Manage library users (students/members)
- Issue books to users
- Return issued books
- Track issued book history
- REST API-based architecture
- Database integration using JPA/Hibernate

---

## 🛠️ Tech Stack
- Java
- Spring Boot
- Spring Data JPA / Hibernate
- REST APIs
- MySQL / PostgreSQL
- Maven

---

## 📏 Business Rules / Constraints
- A book cannot be deleted if it is currently issued to a user
- A user must return a book before deleting their account
- One book can be issued to only one user at a time
- Book availability status updates automatically after issue/return
- System maintains consistency between User and Book records
- Issued book details are stored for tracking history

---

## ⚙️ How to Run
1. Clone the repository  
2. Open the project in IntelliJ IDEA / Eclipse  
3. Configure database settings in `application.properties`  
4. Create required database in MySQL/PostgreSQL  
5. Run the Spring Boot application  
6. Use Postman to test APIs  

---

## 📡 Sample API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /books | Get all books |
| POST | /books | Add new book |
| PUT | /books/{id} | Update book |
| DELETE | /books/{id} | Delete book |
| POST | /issue | Issue book to user |
| POST | /return | Return issued book |

---

## 💡 Project Use Cases
- Library management system for schools/colleges
- Tracking issued and returned books
- Managing student/user records
- Preventing duplicate book issuance
- Maintaining proper library inventory system

---

## 🎯 Key Learning Outcomes
- REST API development using Spring Boot
- Database design and relationships (One-to-Many / Many-to-One)
- CRUD operations with JPA
- Real-world business logic implementation
- Backend system design basics

---

## 👨‍💻 Author
Kulasekhar
