package com.coursemanager;

import java.time.LocalDate;

public class Assignment extends Tasks {

    public Assignment(String title, LocalDate dueDate, double grade, double weight) {
        super(title, dueDate, grade, weight);
    }

    @Override
    public String getType() {
        return "Assignment";
    }
}
