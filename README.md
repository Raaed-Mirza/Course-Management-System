# Course-Management-System
 
# 📚 Course Management System (Java + Maven + SQLite + Java FX)

![Java](https://img.shields.io/badge/Java-17-blue)
![Maven](https://img.shields.io/badge/Maven-3.8.6-red)
![SQLite](https://img.shields.io/badge/SQLite-3-green)

A simple console-based Course Management System rebuilt using **Maven** and **Java 17**, designed to help a student manage their university courses, assignments, and final grades and calculating weighted final grades.

---

## 🚀 Features

- Add, remove, and list your university courses
- Add assignments with:
  - Title
  - Due date
  - Grade
  - Weight (% of final grade)
- View weighted **final grade** per course
- Data persistence using **SQLite**
- Object-Oriented Programming (OOP) principles:
  - Inheritance (`User` → `Student`)
  - Polymorphism (`Tasks` → `Assignment`, `Tests`, `Quizzes`, `Exams`)
  - Encapsulation and abstraction
- Maven project structure and dependency management

---

## 🛠 Technologies Used

- Java 17
- SQLite
- JDBC (SQLite JDBC driver)
- Maven (build + dependency management)

---

## 📦 Project Structure
```
Course-Management-System/
├── pom.xml
├── README.md
├── course_manager.db
├── src/
│ └── main/java/com/coursemanager/
│ ├── Main.java
│ ├── User.java
│ ├── Student.java
│ ├── Assignment.java
│ ├── Exams.java
│ ├── Tests.java
│ ├── Quizzes.java
│ ├── Course.java
│ ├── StudentCourseManager.java
│ └── DatabaseManager.java
```
---

## ✅ How to Run

### 1. Install Maven (if not already)
[https://maven.apache.org/install.html](https://maven.apache.org/install.html)

### 2. Clone
```bash
git clone https://github.com/Raaed-Mirza/Course-Management-System.git
```
```
cd Course-Management-System
```
3. **Compile:**
```
mvn compile
```

4. **Run:**
```bash
mvn exec:java
```

## 💡 Example Use

Enter name: Username

Enter email: username@gmail.com

Welcome, Raaed

1. Add Course
2. Remove Course
3. Add Task to Course
4. Input Grades for Tasks
5. View Courses
6. View Tasks in a Course
7. View Final Grade for a Course
8. Exit
