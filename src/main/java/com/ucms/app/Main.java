package com.ucms.app;

import com.ucms.admin.Admin;
import com.ucms.assessment.Assessment;
import com.ucms.assessment.AssignmentAssessment;
import com.ucms.assessment.TestAssessment;
import com.ucms.assessment.FinalExam;
import com.ucms.domain.Course;
import com.ucms.domain.CourseModule;
import com.ucms.domain.Lecturer;
import com.ucms.domain.Student;
import com.ucms.support.IdGenerator;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** demo system actions */
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
        Admin admin2 = new Admin("Grace", "Hopper", "grace@example.com"); // partial constructor -> chains to full
        Admin admin3 = new Admin("Jane", "Doe", "jane@example.com", "passw0rd", "123 main st, anytown", "089 555 1212", "Supervisor", LocalDate.now());

        System.out.println("[Admin] Created via empty constructor.\n");
        System.out.println("[Admin2] Created via partial constructor: " + admin2.getFirstname() + " " + admin2.getLastname() +", email: " + admin2.getEmail()+"\n");

        System.out.println("[Admin3] Created via full constructor." + admin3.getFirstname() + " " + admin3.getLastname() +", email: "+ admin3.getEmail() +", Contact: " + admin3.getPhone()+", "+ admin3.getAddress()+"\n");
        System.out.println("");


        // add some users
        Student s1 = new Student(
                "Alice", "O'Brien", "alice@example.com", "P4$$w0rd",
                "1 High St", "085-0000001",
                "S001", "BSc CS", 3.42
        );
        Student s2 = new Student(
                "Brian", "Kelly", "brian@example.com", "P4$$w0rd",
                "2 High St", "085-0000002",
                "S002", "BSc CS", 3.10
        );

        Student s3 = new Student(
                "Carol", "Smith", "carol@example.com", "P4$$w0rd",
                "3 High St", "085-0000003",
                "S003", "BSc CS", 3.75
        );
        Student s4 = new Student(
                "David", "Wilson", "david@example.com", "P4$$w0rd",
                "4 High St", "085-0000004",
                "S004", "BSc CS", 3.25
        );
        Student s5 = new Student(
                "Emma", "Brown", "emma@example.com", "P4$$w0rd",
                "5 High St", "085-0000005",
                "S005", "BSc CS", 3.90
        );
        System.out.println("Created students.\n");


        Lecturer lec1 = new Lecturer("Dave", "Jones", "jones@example.com", "P4$$w0rd",
                "Dept Address", "051-0000001",
                "L001", "Computing"
        );
        Lecturer lec2 = new Lecturer("Cathy", "Jones", "cathy@example.com", "P4$$w0rd",
                "3 High St", "085-0000003",
                "S003", "Mathematics"
        );
        Lecturer lec3 = new Lecturer("Michael", "Smith", "michael@example.com", "P4$$w0rd",
                "10 Oak St", "085-0000006",
                "L003", "Physics"
        );
        Lecturer lec4 = new Lecturer("Sarah", "Williams", "sarah@example.com", "P4$$w0rd",
                "15 Maple St", "085-0000007",
                "L004", "Chemistry"
        );
        Lecturer lec5 = new Lecturer("James", "Taylor", "james@example.com", "P4$$w0rd",
                "20 Pine St", "085-0000008",
                "L005", "Biology"
        );
        Lecturer lec6 = new Lecturer(
                "Ann", "Smith", "smith@example.com", "P4$$w0rd",
                "Dept Address", "051-0000002",
                "L006", "Computing");
        System.out.println(" Created lecturers.\n");
        


        admin2.addStudent(students, s1);
        admin.addStudent(students, s2);
        admin.addStudent(students, s3);
        admin2.addStudent(students, s4);
        admin2.addStudent(students, s5);
        admin.addLecturer(lecturers, lec1);
        admin.addLecturer(lecturers, lec2);
        admin2.addLecturer(lecturers, lec3);
        admin.addLecturer(lecturers, lec4);
        admin.addLecturer(lecturers, lec5);
        admin2.addLecturer(lecturers, lec6);
        System.out.println(" Added students and lecturers.\n");

        // --- Course + CourseModules ---
        Course cs = new Course("CS", "Computer Science");
        Course sd = new Course("SD", "Software Design");
        Course mths = new Course("MATHS", "Mathematics");
        Course phy = new Course("PHY", "Physics");
        Course chem = new Course("CHEM", "Chemistry");
        Course bio = new Course("BIO", "Biology");
        System.out.println(" Created courses.\n");
        
        admin.createCourse(courses, cs);
        admin.createCourse(courses, sd);
        admin2.createCourse(courses, mths);
        admin.createCourse(courses, phy);
        admin2.createCourse(courses, chem);
        admin.createCourse(courses, bio);
        System.out.println(" Created courses.\n");
        

        CourseModule m1 = new CourseModule("CS101", "Intro to Programming", lec1);
        CourseModule m2 = new CourseModule("CS102", "Data Structures", lec1);
        CourseModule m3 = new CourseModule("CS103", "Algorithms", lec1);
        CourseModule m4 = new CourseModule("CS104", "Operating Systems", lec1);
        CourseModule m5 = new CourseModule("CS105", "Computer Networks", lec1);
        CourseModule m6 = new CourseModule("CS106", "Computer Graphics", lec1);
        CourseModule m7 = new CourseModule("CS107", "Computer Architecture", lec1);
        CourseModule m8 = new CourseModule("CS108", "Computer Security", lec1);
        CourseModule m9 = new CourseModule("CS109", "Computer Networks", lec1);
        CourseModule m10 = new CourseModule("MTHS101", "Mathematics 101", lec2);
        CourseModule m11 = new CourseModule("PHY101", "Physics 101", lec3);
        CourseModule m12 = new CourseModule("CHEM101", "Chemistry 101", lec4);
        CourseModule m13 = new CourseModule("BIO101", "Biology 101", lec5);
        CourseModule m14 = new CourseModule("CS201", "Intro to Programming", lec6);
        CourseModule m15 = new CourseModule("CS202", "Data Structures", lec6);
        CourseModule m16 = new CourseModule("SD101", "Software Design 1", lec6);

        System.out.println(" Created course modules.\n");
        
        
        courseModules.add(m1);
        courseModules.add(m2);
        courseModules.add(m3);
        courseModules.add(m4);
        courseModules.add(m5);
        courseModules.add(m6);
        courseModules.add(m7);
        courseModules.add(m8);
        courseModules.add(m9);
        courseModules.add(m10);
        courseModules.add(m11);
        courseModules.add(m12);
        courseModules.add(m13);
        courseModules.add(m14);
        courseModules.add(m15);
        courseModules.add(m16);
        System.out.println(" Added course modules to list.\n");

        admin.addCourseModuleToCourse(cs, m1);
        admin.addCourseModuleToCourse(cs, m2);
        admin.addCourseModuleToCourse(cs, m3);
        admin.addCourseModuleToCourse(cs, m4);
        admin.addCourseModuleToCourse(cs, m5);
        admin2.addCourseModuleToCourse(cs, m6);
        admin.addCourseModuleToCourse(cs, m7);
        admin2.addCourseModuleToCourse(cs, m8);
        admin2.addCourseModuleToCourse(cs, m9);
        admin.addCourseModuleToCourse(mths, m10);
        admin.addCourseModuleToCourse(phy, m11);
        admin2.addCourseModuleToCourse(chem, m12);
        admin.addCourseModuleToCourse(bio, m13);
        admin.addCourseModuleToCourse(cs, m14);
        admin2.addCourseModuleToCourse(cs, m15);
        admin2.addCourseModuleToCourse(sd, m16);
        System.out.println("Added course modules to courses.\n");
        
        
        admin.assignCourseModuleToLecturer(m1, lec1);
        admin2.assignCourseModuleToLecturer(m2, lec1);
        admin2.assignCourseModuleToLecturer(m3, lec1);
        admin2.assignCourseModuleToLecturer(m4, lec1);
        admin.assignCourseModuleToLecturer(m5, lec1);
        admin.assignCourseModuleToLecturer(m6, lec1);
        admin.assignCourseModuleToLecturer(m7, lec1);
        admin.assignCourseModuleToLecturer(m8, lec1);
        admin.assignCourseModuleToLecturer(m9, lec1);
        admin2.assignCourseModuleToLecturer(m10, lec2);
        admin2.assignCourseModuleToLecturer(m11, lec3);
        admin.assignCourseModuleToLecturer(m12, lec4);
        admin.assignCourseModuleToLecturer(m13, lec5);
        admin.assignCourseModuleToLecturer(m14, lec6);
        admin2.assignCourseModuleToLecturer(m15, lec6);
        admin3.assignCourseModuleToLecturer(m16, lec6);
        System.out.println(" Assigned course modules to lecturers.\n");

        // --- Assessments (polymorphic list) ---
        LocalDate today = LocalDate.now();
        assessments.add(new FinalExam(
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
        // Add assessments for remaining modules
        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m2, s2, lec1,
                50, 0.3,
                today.minusDays(20),
                today.plusDays(10),
                false
        ));

        assessments.add(new TestAssessment(
                IdGenerator.next("A"),
                m3, s3, lec1,
                45, 0.25,
                today.minusDays(5),
                today.plusDays(2),
                15
        ));

        assessments.add(new FinalExam(
                IdGenerator.next("A"),
                m4, s4, lec1,
                90, 0.5,
                today.minusDays(15),
                today.plusDays(15),
                Duration.ofHours(3),
                12
        ));

        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m5, s5, lec1,
                70, 0.4,
                today.minusDays(10),
                today.plusDays(5),
                true
        ));

        assessments.add(new TestAssessment(
                IdGenerator.next("A"),
                m6, s1, lec1,
                40, 0.3,
                today.minusDays(7),
                today.plusDays(3),
                20
        ));

        assessments.add(new FinalExam(
                IdGenerator.next("A"),
                m7, s2, lec1,
                100, 0.6,
                today.minusDays(25),
                today.plusDays(20),
                Duration.ofHours(4),
                15
        ));

        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m8, s3, lec1,
                60, 0.35,
                today.minusDays(12),
                today.plusDays(8),
                false
        ));

        assessments.add(new TestAssessment(
                IdGenerator.next("A"),
                m9, s4, lec1,
                50, 0.4,
                today.minusDays(8),
                today.plusDays(4),
                25
        ));

        assessments.add(new FinalExam(
                IdGenerator.next("A"),
                m10, s5, lec2,
                85, 0.5,
                today.minusDays(18),
                today.plusDays(12),
                Duration.ofHours(2),
                10
        ));

        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m11, s1, lec3,
                75, 0.45,
                today.minusDays(15),
                today.plusDays(7),
                true
        ));

        assessments.add(new TestAssessment(
                IdGenerator.next("A"),
                m12, s2, lec4,
                55, 0.35,
                today.minusDays(6),
                today.plusDays(5),
                18
        ));

        assessments.add(new FinalExam(
                IdGenerator.next("A"),
                m13, s3, lec5,
                95, 0.55,
                today.minusDays(22),
                today.plusDays(18),
                Duration.ofHours(3),
                14
        ));

        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m14, s4, lec6,
                65, 0.4,
                today.minusDays(13),
                today.plusDays(6),
                false
        ));

        assessments.add(new TestAssessment(
                IdGenerator.next("A"),
                m15, s5, lec6,
                45, 0.3,
                today.minusDays(9),
                today.plusDays(1),
                22
        ));

        assessments.add(new FinalExam(
                IdGenerator.next("A"),
                m16, s1, lec6,
                80, 0.5,
                today.minusDays(20),
                today.plusDays(14),
                Duration.ofHours(2),
                11
        ));

        System.out.println(" Added assessments to list.\n");

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
        cs.viewStudents();

        System.out.println("\n== Lecturer View ==");
        lec1.viewCourseModules();
        lec2.viewCourseModules();
        lec3.viewCourseModules();
        lec4.viewCourseModules();
        lec5.viewCourseModules();
        lec6.viewCourseModules();


        System.out.println("\nDone.");
    }
}
