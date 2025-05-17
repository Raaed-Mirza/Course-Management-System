package com.coursemanager;

import java.time.LocalDate;

public class Test extends Tasks {

    public Test(String title, LocalDate dueDate, double grade, double weight) {
        super(title, dueDate, grade, weight);
    }

    @Override
    public String getType() {
        return "Test";
    }
}
