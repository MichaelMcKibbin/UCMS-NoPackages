package com.ucms.app;

import com.ucms.admin.Admin;
import com.ucms.assessment.Assessment;
import com.ucms.assessment.AssignmentAssessment;
import com.ucms.assessment.TestAssessment;
import com.ucms.domain.Course;
import com.ucms.domain.CourseModule;
import com.ucms.domain.Lecturer;
import com.ucms.domain.Student;
import com.ucms.support.IdGenerator;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Minimal demo that exercises Admin actions and polymorphism over assessments. */
public class Main {
    public static void main(String[] args) {
        // --- Repos ---
        List<Student> students = new ArrayList<>();
        List<Lecturer> lecturers = new ArrayList<>();
        List<CourseModule> courseModules = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Assessment> assessments = new ArrayList<>();

        // --- Actors ---
        Admin admin = new Admin(); // uses chained constructor

        // Your classes appear to have full constructors like below:
        Student s1 = new Student(
                "Alice", "O'Brien", "alice@example.com", "pw",
                "1 High St", "085-0000001",
                "S001", "BSc CS", 3.42
        );
        Student s2 = new Student(
                "Brian", "Kelly", "brian@example.com", "pw",
                "2 High St", "085-0000002",
                "S002", "BSc CS", 3.10
        );

        Lecturer lec1 = new Lecturer(
                "Dr", "Jones", "jones@example.com", "pw",
                "Dept Address", "051-0000001",
                "L001", "Computing"
        );

        admin.addStudent(students, s1);
        admin.addStudent(students, s2);
        admin.addLecturer(lecturers, lec1);

        // --- Course + CourseModules ---
        Course cs = new Course("CS", "Computer Science");
        admin.createCourse(courses, cs);

        CourseModule m1 = new CourseModule("CS101", "Intro to Programming", lec1);
        CourseModule m2 = new CourseModule("CS102", "Data Structures", lec1);
        courseModules.add(m1);
        courseModules.add(m2);

        admin.addCourseModuleToCourse(cs, m1);
        admin.addCourseModuleToCourse(cs, m2);
        admin.assignCourseModuleToLecturer(m1, lec1);
        admin.assignCourseModuleToLecturer(m2, lec1);

        // --- Assessments (polymorphic list) ---
        LocalDate today = LocalDate.now();
        assessments.add(new com.ucms.assessment.FinalExam(
                IdGenerator.next("A"),
                m1, s1, lec1,
                100, 0.6,
                today.minusDays(30),
                today.plusDays(7),
                Duration.ofHours(2),
                10
        ));

        assessments.add(new TestAssessment(
                IdGenerator.next("A"),
                m1, s1, lec1,
                40, 0.2,
                today.minusDays(10),
                today.minusDays(1),  // already due
                20
        ));

        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m2, s1, lec1,
                60, 0.2,
                today.minusDays(14),
                today.plusDays(3),
                true
        ));

        // --- Demo outputs ---
        System.out.println("\n== Assessments ==");
        for (Assessment a : assessments) {
            System.out.println(a.summary()
                    + " | overdue=" + a.isOverdue(today)
                    + " | weighted(achieved=80% of total)="
                    + String.format("%.2f", a.weightedScore((int)(a.getTotalMarks() * 0.8))));
        }

        System.out.println("\n== Course View ==");
        System.out.println(cs);
        cs.viewCourseModules();
        cs.viewStudents(); // will be empty unless you enroll; call cs.enrollStudent(s1) if present in your class

        System.out.println("\n== Lecturer View ==");
        lec1.viewCourseModules();

        System.out.println("\nDone.");
    }
}
