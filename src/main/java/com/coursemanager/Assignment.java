package com.coursemanager;

import java.time.LocalDate;

public class Assignment {

    private String title;
    private LocalDate dueDate;
    private double grade;
    private double weight;

    public Assignment(String title, LocalDate dueDate, double grade, double weight) {
        this.title = title;
        this.dueDate = dueDate;
        this.grade = grade;
        this.weight = weight;
    }

    public double getGrade() {
        return grade;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Assignment{"
                + "title='" + title + '\''
                + ", dueDate=" + dueDate
                + ", grade=" + grade
                + ", weight=" + weight
                + '}';

    }
}
