package com.coursemanager;

import java.time.LocalDate;

public class Tests extends Tasks {

    public Tests(String title, LocalDate dueDate, double grade, double weight) {
        super(title, dueDate, grade, weight);
    }

    @Override
    public String getType() {
        return "Test";
    }
}
