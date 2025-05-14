package com.coursemanager;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {

    private List<Course> teachingCourses = new ArrayList<>();

    public Instructor(String name, String email) {
        super(name, email);
    }

    public void addCourse(Course course) {
        teachingCourses.add(course);
    }

    @Override
    public void printDashboard() {
        System.out.println("Welcome, " + name + " (Instructor)");
        for (Course c : teachingCourses) {
            System.out.println("Teaching: " + c);
        }
    }
}
