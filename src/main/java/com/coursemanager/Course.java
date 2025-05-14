package com.coursemanager;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseCode;
    private String courseName;
    private String instructorName;
    private double credits;
    private List<Assignment> assignments;

    public Course(String courseCode, String courseName, String instructorName, double credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.credits = credits;
        this.assignments = new ArrayList<>();
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public double getCredits() {
        return credits;
    }

    public double getFinalGrade() {
        double total = 0;
        for (Assignment a : assignments) {
            total += a.getGrade() * (a.getWeight() / 100);
        }
        return total;
    }

    public String toString() {
        return courseCode + ": " + courseName + " | Instructor: " + instructorName + " | Credits: " + credits;
    }
}
