package com.coursemanager;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your student ID: ");
        String userId = sc.nextLine();

        Student student = new Student(name, email, userId);
        StudentCourseManager scm = new StudentCourseManager(); // Fixed: Create manager separately

        while (true) {
            System.out.println("""
                \n1. Add Course
                2. Remove Course
                3. Add Task to Course
                4. Input Grades for Tasks
                5. View Courses
                6. View Tasks in a Course
                7. View Final Grade for a Course
                8. Exit""");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Course code: ");
                    String code = sc.nextLine();
                    System.out.print("Course name: ");
                    String cname = sc.nextLine();
                    System.out.print("Credits: ");
                    double credits = sc.nextDouble();
                    sc.nextLine();
                    Course course = new Course(code, cname, credits);
                    scm.addCourse(course);
                }

                case 2 -> {
                    System.out.print("Enter course code to remove: ");
                    scm.removeCourse(sc.nextLine());
                }

                case 3 -> {
                    System.out.print("Course code: ");
                    Course course = scm.findCourse(sc.nextLine());
                    if (course != null) {
                        System.out.print("Task title: ");
                        String title = sc.nextLine();
                        System.out.print("Due date (YYYY-MM-DD): ");
                        LocalDate date = LocalDate.parse(sc.nextLine());
                        System.out.print("Weight (%): ");
                        double weight = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Type (assignment/test/exam/quiz): ");
                        String type = sc.nextLine().toLowerCase();

                        Tasks task = switch (type) {
                            case "assignment" ->
                                new Assignment(title, date, -1, weight);
                            case "test" ->
                                new Tests(title, date, -1, weight);
                            case "exam" ->
                                new Exams(title, date, -1, weight);
                            case "quiz" ->
                                new Quizzes(title, date, -1, weight);
                            default ->
                                null;
                        };

                        if (task != null) {
                            course.addTasks(task);
                        } else {
                            System.out.println("Invalid task type.");
                        }
                    } else {
                        System.out.println("Course not found.");
                    }
                }

                case 4 -> {
                    System.out.print("Course code: ");
                    Course course = scm.findCourse(sc.nextLine());
                    if (course != null) {
                        for (Tasks task : course.getTasks()) {
                            System.out.print("Enter grade for " + task.getTitle() + " (" + task.getType() + "): ");
                            double grade = sc.nextDouble();
                            sc.nextLine();
                            task.setGrade(grade);
                        }
                    } else {
                        System.out.println("Course not found.");
                    }
                }

                case 5 ->
                    scm.displayCourses();

                case 6 -> {
                    System.out.print("Course code: ");
                    Course course = scm.findCourse(sc.nextLine());
                    if (course != null) {
                        scm.displayTasks(course);
                    } else {
                        System.out.println("Course not found.");
                    }
                }

                case 7 -> {
                    System.out.print("Course code: ");
                    Course course = scm.findCourse(sc.nextLine());
                    if (course != null) {
                        System.out.print("Weight for Assignments (%): ");
                        double assignmentsWeight = sc.nextDouble();
                        System.out.print("Weight for Tests (%): ");
                        double testsWeight = sc.nextDouble();
                        System.out.print("Weight for Quizzes (%): ");
                        double quizzesWeight = sc.nextDouble();
                        System.out.print("Weight for Exams (%): ");
                        double examsWeight = sc.nextDouble();
                        sc.nextLine();

                        if (assignmentsWeight + testsWeight + quizzesWeight + examsWeight > 100) {
                            System.out.println("Error: Weights exceed 100%!");
                            continue;
                        }

                        double finalGrade = course.calculateFinalGrade(
                                assignmentsWeight, testsWeight, quizzesWeight, examsWeight
                        );

                        System.out.printf("Final grade for %s: %.2f%%\n",
                                course.getCourseName(), finalGrade);
                    } else {
                        System.out.println("Course not found.");
                    }
                }

                case 8 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }

                default ->
                    System.out.println("Invalid choice.");
            }
        }
    }
}
