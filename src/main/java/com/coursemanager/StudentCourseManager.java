package com.coursemanager;

import java.util.ArrayList;
import java.util.List;

public class StudentCourseManager {

    private List<Course> courses;

    public StudentCourseManager() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(String courseCode) {
        courses.removeIf(course -> course.getCourseCode().equals(courseCode));
    }

    public Course findCourse(String code) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println(course.getCourseName() + " (" + course.getCourseCode() + ") - " + course.getInstructorName());
        }
    }

}
