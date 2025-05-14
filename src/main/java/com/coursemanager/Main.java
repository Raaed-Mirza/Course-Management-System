package com.coursemanager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DatabaseManager.initDatabase();
        User user;
        Scanner sc = new Scanner(System.in);

        System.out.println("Login as:\n1. Student\n2. Instructor");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        if (type == 1) {
            user = new Student(name, email);
        } else {
            user = new Instructor(name, email);
        }

        user.printDashboard();

        if (user instanceof Student student) {
            StudentCourseManager scm = student.getManager();
            List<Course> savedCourses = DatabaseManager.loadCourses();
            for (Course c : savedCourses) {
                scm.addCourse(c);
            }

            while (true) {
                System.out.println("""
                    \n1. Add Course
                    2. Remove Course
                    3. Add Assignment
                    4. View Courses
                    5. View Final Grade for a Course
                    6. Exit""");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Course code: ");
                        String code = sc.nextLine();
                        System.out.print("Course name: ");
                        String cname = sc.nextLine();
                        System.out.print("Instructor: ");
                        String inst = sc.nextLine();
                        System.out.print("Credits: ");
                        int credits = sc.nextInt();
                        sc.nextLine();
                        Course course = new Course(code, cname, inst, credits);
                        scm.addCourse(course);
                        DatabaseManager.insertCourse(course); // Optional DB insert
                    }
                    case 2 -> {
                        System.out.print("Enter course code to remove: ");
                        scm.removeCourse(sc.nextLine());
                        // You can optionally remove from DB
                    }
                    case 3 -> {
                        System.out.print("Course code: ");
                        String code = sc.nextLine();
                        Course c = scm.findCourse(code);
                        if (c != null) {
                            System.out.print("Assignment title: ");
                            String title = sc.nextLine();
                            System.out.print("Due date (YYYY-MM-DD): ");
                            LocalDate date = LocalDate.parse(sc.nextLine());
                            System.out.print("Grade (e.g., 85): ");
                            double grade = sc.nextDouble();
                            System.out.print("Weight (% of final grade): ");
                            double weight = sc.nextDouble();
                            sc.nextLine();

                            Assignment a = new Assignment(title, date, grade, weight);
                            c.addAssignment(a);
                        } else {
                            System.out.println("Course not found.");
                        }
                    }
                    case 4 -> {
                        scm.displayCourses();
                    }
                    case 5 -> {
                        System.out.print("Enter course code: ");
                        Course c = scm.findCourse(sc.nextLine());
                        if (c != null) {
                            System.out.printf("Final grade for %s: %.2f\n", c.getCourseName(), c.getFinalGrade());
                        } else {
                            System.out.println("Course not found.");
                        }
                    }
                    case 6 -> {
                        System.out.println("Bye!");
                        return;
                    }
                    default ->
                        System.out.println("Invalid choice.");
                }
            }
        }
    }
}
