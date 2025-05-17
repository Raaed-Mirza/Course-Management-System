package com.coursemanager;

import java.time.LocalDate;

public class Quizzes extends Tasks {

    public Quizzes(String title, LocalDate dueDate, double grade, double weight) {
        super(title, dueDate, grade, weight);
    }

    @Override
    public String getType() {
        return "Quiz";
    }
}
