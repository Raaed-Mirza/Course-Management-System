package com.coursemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:course_manager.db";

    public static void initDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");

            try (Connection conn = DriverManager.getConnection(DB_URL); Statement stmt = conn.createStatement()) {

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS courses ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "code TEXT NOT NULL,"
                        + "name TEXT NOT NULL,"
                        + "instructor TEXT,"
                        + "credits REAL);");  // changed INTEGER -> REAL for decimal credits

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS assignments ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "course_id INTEGER,"
                        + "title TEXT NOT NULL,"
                        + "due_date TEXT,"
                        + "grade REAL,"
                        + "weight REAL,"
                        + "FOREIGN KEY(course_id) REFERENCES courses(id));");

            }
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        }
    }

    public static void insertCourse(Course course) {
        String sql = "INSERT INTO courses (code, name, instructor, credits) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, course.getCourseCode());
            pstmt.setString(2, course.getCourseName());
            pstmt.setString(3, course.getInstructorName());
            pstmt.setDouble(4, course.getCredits());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC"); // <-- REQUIRED here too

            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM courses");

            while (rs.next()) {
                Course course = new Course(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getString("instructor"),
                        rs.getDouble("credits") // double because we now use decimal credits
                );
                courses.add(course);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
}
