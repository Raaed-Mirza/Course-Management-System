package com.coursemanager;

import java.time.LocalDate;

public class Exams extends Tasks {

    public Exams(String title, LocalDate dueDate, double grade, double weight) {
        super(title, dueDate, grade, weight);
    }

    @Override
    public String getType() {
        return "Exam";
    }
}
