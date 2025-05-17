package com.coursemanager;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private List<Course> enrolledCourses;

    public Student(String name, String email, String userId) {
        super(name, email, userId);
        this.enrolledCourses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void removeCourse(Course course) {
        enrolledCourses.remove(course);
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
}
