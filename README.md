# Course-Management-System
 
# 📚 Course Management System (Java + Maven + SQLite)

A simple console-based Course Management System rebuilt using **Maven** and **Java 17**, designed to help a student manage their university courses, assignments, and final grades using weighted evaluation components.

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
  - Inheritance (`User`, `Student`, `Instructor`)
  - Composition (`Course` has `Assignments`)
  - Polymorphism via dashboard method
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
│ ├── Instructor.java
│ ├── Assignment.java
│ ├── Course.java
│ ├── StudentCourseManager.java
│ └── DatabaseManager.java

---

## ✅ How to Run

### 1. Install Maven (if not already)
[https://maven.apache.org/install.html](https://maven.apache.org/install.html)

### 2. Clone and compile
```bash
git clone https://github.com/Raaed-Mirza/Course-Management-System.git
cd Course-Management-System


4. **Run:**
```bash
mvn exec:java
```

## 💡 Example Use
Login as:
1. Student
2. Instructor
> 1

Enter name: Username
Enter email: username@gmail.com

Welcome, Username (Student)

1. Add Course
2. Remove Course
3. Add Assignment
4. View Courses
5. View Final Grade for a Course
6. Exit
