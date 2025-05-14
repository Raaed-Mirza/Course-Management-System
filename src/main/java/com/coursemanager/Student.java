package com.coursemanager;

public class Student extends User {

    private StudentCourseManager manager;

    public Student(String name, String email) {
        super(name, email);
        this.manager = new StudentCourseManager();
    }

    public StudentCourseManager getManager() {
        return manager;
    }

    @Override
    public void printDashboard() {
        System.out.println("Welcome, " + name + " (Student)");
        manager.displayCourses();
    }
}
