package com.coursemanager;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseCode;
    private String courseName;
    private double credits;
    private List<Tasks> tasks;

    public Course(String courseCode, String courseName, double credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.tasks = new ArrayList<>();
    }

    public void addTasks(Tasks task) {
        tasks.add(task);
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCredits() {
        return credits;
    }

    public String toString() {
        return courseCode + ": " + courseName + " | Credits: " + credits;
    }

    public double getWeightedGradeByType(String type) {
        double weightedSum = 0;
        double totalWeight = 0;

        for (Tasks task : tasks) {
            if (task.getType().equalsIgnoreCase(type) && task.getGrade() >= 0) {
                weightedSum += task.getGrade() * (task.getWeight() / 100);
                totalWeight += task.getWeight();
            }
        }
        return (totalWeight == 0) ? 0 : weightedSum / totalWeight;
    }

    public double calculateFinalGrade(double assginmentsWeight, double testsWeight, double examsWeight, double quizzesWeight) {
        double assginmentsGrade = getWeightedGradeByType("Assignment") * (assginmentsWeight / 100);
        double testsGrade = getWeightedGradeByType("Test") * (testsWeight / 100);
        double examsGrade = getWeightedGradeByType("Exam") * (examsWeight / 100);
        double quizzesGrade = getWeightedGradeByType("Quiz") * (quizzesWeight / 100);

        return assginmentsGrade + testsGrade + examsGrade + quizzesGrade;

    }
}
