# Course-Management-System
 
# 📚 Course Management System (Java + SQLite)

A simple console-based Course Management System built using Java and SQLite, designed to help a student manage their university courses, assignments, and final grades using weighted evaluation components.

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

---

## 🛠 Technologies

- Java (JDK 17+)
- SQLite
- JDBC (SQLite JDBC driver)

---

## 📦 Project Structure
Course-Management-System/
├── Main.java
├── User.java
├── Student.java
├── Instructor.java
├── Assignment.java
├── Course.java
├── StudentCourseManager.java
├── DatabaseManager.java
├── course_manager.db (created at runtime)
└── sqlite-jdbc-<version>.jar

---

## ✅ How to Run

1. **Download the SQLite JDBC driver:**
   [https://github.com/xerial/sqlite-jdbc/releases](https://github.com/xerial/sqlite-jdbc/releases)

2. **Place the `.jar` in the project folder**  
   e.g., `sqlite-jdbc-3.36.0.3.jar`

3. **Compile:**
   ```bash
   javac -cp ".;sqlite-jdbc-3.36.0.3.jar" *.java
   ```

4. **Run:**
```bash
java -cp ".;sqlite-jdbc-3.36.0.3.jar" Main
```

## 💡 Example Use
Login as:
1. Student
2. Instructor
> 1

Enter name: Username
Enter email: username@gmail.com

Welcome, Raaed (Student)

1. Add Course
2. Remove Course
3. Add Assignment
4. View Courses
5. View Final Grade for a Course
6. Exit
