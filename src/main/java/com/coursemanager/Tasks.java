package com.coursemanager;

import java.time.LocalDate;

public abstract class Tasks {

    protected String title;
    protected LocalDate dueDate;
    protected double grade;
    protected double weight;

    public Tasks(String title, LocalDate dueDate, double grade, double weight) {
        this.title = title;
        this.dueDate = dueDate;
        this.weight = weight;
        this.grade = -1;
    }

    public double getGrade() {
        return grade;
    }

    public double getWeight() {
        return weight;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public abstract String getType();
}
