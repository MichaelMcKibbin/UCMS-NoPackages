package com.ucms;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
* demo system actions
*/

public class Main {
    public static void main(String[] args) {
        //  in-memory collections (repos) 
        List<Student> students = new ArrayList<>();
        List<Lecturer> lecturers = new ArrayList<>();
        List<CourseModule> courseModules = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Assessment> assessments = new ArrayList<>();

        //  Actors 
        Admin admin = new Admin(); // uses chained constructor
        Admin admin2 = new Admin("Jenny", "Block", "jenny@mail.com"); // partial constructor -> chains to full
        Admin admin3 = new Admin("Jane", "Doe", "jane@mail.com", "P4$$w0rd", "123 main st, anytown", "089 555 1212", "Supervisor", LocalDate.now());

        // CREATE SOME TEST DATA
        
        System.out.println("\n[Admin] Created via empty constructor.\n");
        System.out.println("\n[Admin2] Created via partial constructor: " + admin2.getFirstname() + " " + admin2.getLastname() +", email: " + admin2.getEmail()+"\n");
        System.out.println("\n[Admin3] Created via full constructor." + admin3.getFirstname() + " " + admin3.getLastname() +", email: "+ admin3.getEmail() +", Contact: " + admin3.getPhone()+", "+ admin3.getAddress()+"\n");
        System.out.println("\n");


        // add some users - students, lecturers
        System.out.println("\n Adding Students...\n");
        Student s1 = new Student(
                "Aoife", "O'Brien", "aoife@mail.com", "P4$$w0rd",
                "1 Main St", "085 123 4567",
                "S001", "CS", 3.42
        );
        Student s2 = new Student(
                "Brendan", "Kelly", "brian@mail.com", "P4$$w0rd",
                "2 Main St", "085 234 5678",
                "S002", "CS", 3.10
        );

        Student s3 = new Student(
                "Carol", "Smith", "carol@mail.com", "P4$$w0rd",
                "3 Main St", "085 345 6789",
                "S003", "MATHS", 3.75
        );
        Student s4 = new Student(
                "David", "Davidson", "david@mail.com", "P4$$w0rd",
                "4 Main St", "086 123 4567",
                "S004", "PHY", 3.25
        );
        Student s5 = new Student(
                "Emma", "Gonago", "emma@mail.com", "P4$$w0rd",
                "5 Main St", "086 234 5678",
                "S005", "CS", 3.90
        );
        // add more students
        Student s6 = new Student(
                "Fiona", "Ferguson", "XXXXXXXXXXXXXX", "P4$$w0rd",
                "6 Main St", "000000000000",
                "S006", "MATHS", 3.60
        );
        Student s7 = new Student(
                "George", "Gibson", "XXXXXXXXXXXXXX", "P4$$w0rd",
                "7 Main St", "000000000000",
                "S007", "PHY", 3.40
        );
        Student s8 = new Student(
                "Hannah", "Harris", "XXXXXXXXXXXXXX", "P4$$w0rd",
                "8 Main St", "000000000000",
                "S008", "CS", 3.80
        );
        Student s9 = new Student(
                "Ian", "Ingram", "XXXXXXXXXXXXXX", "P4$$w0rd",
                "9 Main St", "000000000000",
                "S009", "MATHS", 3.50
        );
        Student s10 = new Student(
                "Jane", "Johnson", "XXXXXXXXXXXXXX", "P4$$w0rd",
                "10 Main St", "000000000000",
                "S010", "PHY", 3.20
        );
        System.out.println("\nCreated students.\n");

        System.out.println("\n Adding Lecturers...\n");

        Lecturer lec1 = new Lecturer("Peter", "Copper", "pc@mail.com", "P4$$w0rd",
                "999 Lettsby Ave", "01 123 4567",
                "L001", "Computing"
        );
        Lecturer lec2 = new Lecturer("Cathy", "Bates", "cathy@mail.com", "P4$$w0rd",
                "3 Main St", "086 123 4567",
                "S003", "Mathematics"
        );
        Lecturer lec3 = new Lecturer("Michael", "Myers", "michael@mail.com", "P4$$w0rd",
                "3 Main St", "087 123 4567 ",
                "L003", "Physics"
        );
        Lecturer lec4 = new Lecturer("Bill", "Williamson", "bill@mail.com", "P4$$w0rd",
                "15 Back St", "088 123 4567",
                "L004", "Chemistry"
        );
        Lecturer lec5 = new Lecturer("James", "Jameson", "james@mail.com", "P4$$w0rd",
                "20 Back St", "089 123 4567",
                "L005", "Biology"
        );
        Lecturer lec6 = new Lecturer(
                "Stan", "Smith", "smith@mail.com", "P4$$w0rd",
                "99 Nowhere St", "089 234 5678",
                "L006", "Computing");
        //add more lecturers
        Lecturer lec7 = new Lecturer(
                "Jane", "Doe", "XXXXXXXXXXXXXX", "P4$$w0rd",
                "99 Nowhere St", "000000000000",
                "L007", "Mathematics");
        Lecturer lec8 = new Lecturer(
                "John", "Doe", "XXXXXXXXXXXXXX", "P4$$w0rd",
                "99 Nowhere St", "000000000000",
                "L008", "Physics");
        Lecturer lec9 = new Lecturer(
                "Jane", "Doe", "XXXXXXXXXXXXXX", "P4$$w0rd",
                "99 Nowhere St", "000000000000",
                "L009", "Chemistry");
        Lecturer lec10 = new Lecturer(
                "John", "Doe", "XXXXXXXXXXXXXX", "P4$$w0rd",
                "99 Nowhere St", "000000000000",
                "L010", "Biology");
        System.out.println("\n Created lecturers.\n");


        System.out.println("\n Adding Students...\n");
        admin2.addStudent(students, s1);
        admin.addStudent(students, s2);
        admin.addStudent(students, s3);
        admin2.addStudent(students, s4);
        admin2.addStudent(students, s5);
        admin.addStudent(students, s6);
        admin.addStudent(students, s7);
        admin.addStudent(students, s8);
        admin.addStudent(students, s9);
        admin.addStudent(students, s10);
        System.out.println("\n Added students.\n");


        admin.addLecturer(lecturers, lec1);
        admin.addLecturer(lecturers, lec2);
        admin2.addLecturer(lecturers, lec3);
        admin.addLecturer(lecturers, lec4);
        admin.addLecturer(lecturers, lec5);
        admin2.addLecturer(lecturers, lec6);
        System.out.println("\n Added lecturers.\n");

        // Course + CourseModules
        Course cs = new Course("CS", "Computer Science");
        Course sd = new Course("SD", "Software Design");
        Course mths = new Course("MATHS", "Mathematics");
        Course phy = new Course("PHY", "Physics");
        Course chem = new Course("CHEM", "Chemistry");
        Course bio = new Course("BIO", "Biology");
        System.out.println("\n Created courses.\n");
        
        admin.createCourse(courses, cs);
        admin.createCourse(courses, sd);
        admin2.createCourse(courses, mths);
        admin.createCourse(courses, phy);
        admin2.createCourse(courses, chem);
        admin.createCourse(courses, bio);
        System.out.println("\n Created courses.\n");
        

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
        CourseModule m17 = new CourseModule("MTHS102", "Mathematics 102", lec7);
        CourseModule m18 = new CourseModule("PHY102", "Physics 102", lec8);
        CourseModule m19 = new CourseModule("CHEM102", "Chemistry 102", lec9);
        CourseModule m20 = new CourseModule("BIO102", "Biology 102", lec10);
        CourseModule m21 = new CourseModule("CS203", "Intro to Programming", lec6);
        CourseModule m22 = new CourseModule("CS204", "Data Structures", lec6);
        CourseModule m23 = new CourseModule("CS205", "Algorithms", lec6);
        CourseModule m24 = new CourseModule("CS206", "Operating Systems", lec6);
        CourseModule m25 = new CourseModule("CS207", "Computer Networks", lec6);
        CourseModule m26 = new CourseModule("CS208", "Computer Graphics", lec6);
        CourseModule m27 = new CourseModule("CS209", "Computer Architecture", lec6);
        CourseModule m28 = new CourseModule("CS210", "Computer Security", lec6);
        CourseModule m29 = new CourseModule("CS211", "Computer Networks", lec6);
        CourseModule m30 = new CourseModule("MTHS103", "Mathematics 103", lec7);

        System.out.println("\n Created course modules.\n");
        
        
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
        courseModules.add(m17);
        courseModules.add(m18);
        courseModules.add(m19);
        courseModules.add(m20);
        courseModules.add(m21);
        courseModules.add(m22);
        courseModules.add(m23);
        courseModules.add(m24);
        courseModules.add(m25);
        courseModules.add(m26);
        courseModules.add(m27);
        courseModules.add(m28);
        courseModules.add(m29);
        courseModules.add(m30);
        System.out.println("\n Added course modules to list.\n");

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
        admin.addCourseModuleToCourse(mths, m17);
        admin2.addCourseModuleToCourse(phy, m18);
        admin2.addCourseModuleToCourse(chem, m19);
        admin.addCourseModuleToCourse(bio, m20);
        admin.addCourseModuleToCourse(cs, m21);
        admin.addCourseModuleToCourse(cs, m22);
        admin.addCourseModuleToCourse(cs, m23);
        admin.addCourseModuleToCourse(cs, m24);
        admin.addCourseModuleToCourse(cs, m25);
        admin.addCourseModuleToCourse(cs, m26);
        admin.addCourseModuleToCourse(cs, m27);
        admin.addCourseModuleToCourse(cs, m28);
        admin.addCourseModuleToCourse(cs, m29);
        admin.addCourseModuleToCourse(mths, m30);
        System.out.println("\nAdded course modules to courses.\n");
        
        
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
        admin.assignCourseModuleToLecturer(m17, lec7);
        admin.assignCourseModuleToLecturer(m18, lec8);
        admin.assignCourseModuleToLecturer(m19, lec9);
        admin.assignCourseModuleToLecturer(m20, lec10);
        admin.assignCourseModuleToLecturer(m21, lec6);
        admin.assignCourseModuleToLecturer(m22, lec6);
        admin.assignCourseModuleToLecturer(m23, lec6);
        admin.assignCourseModuleToLecturer(m24, lec6);
        admin.assignCourseModuleToLecturer(m25, lec6);
        admin.assignCourseModuleToLecturer(m26, lec6);
        admin.assignCourseModuleToLecturer(m27, lec6);
        admin.assignCourseModuleToLecturer(m28, lec6);
        admin.assignCourseModuleToLecturer(m29, lec6);
        admin.assignCourseModuleToLecturer(m30, lec7);

        System.out.println("\n Assigned course modules to lecturers.\n");


        // enrol students on courses
        cs.enrollStudent(s1);
        cs.enrollStudent(s2);
        cs.enrollStudent(s5);
        cs.enrollStudent(s8);
        mths.enrollStudent(s3);
        mths.enrollStudent(s6);
        mths.enrollStudent(s9);
        phy.enrollStudent(s4);
        phy.enrollStudent(s7);
        phy.enrollStudent(s10);


        //  Assessments (a polymorphic list) 
        LocalDate today = LocalDate.now();
        assessments.add(new FinalExamAssessment(
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

        assessments.add(new FinalExamAssessment(
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

        assessments.add(new FinalExamAssessment(
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

        assessments.add(new FinalExamAssessment(
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

        assessments.add(new FinalExamAssessment(
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

        assessments.add(new FinalExamAssessment(
                IdGenerator.next("A"),
                m16, s1, lec6,
                80, 0.5,
                today.minusDays(20),
                today.plusDays(14),
                Duration.ofHours(2),
                11
        ));

        //add more assessments
        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m17, s2, lec7,
                70, 0.4,
                today.minusDays(18),
                today.plusDays(10),
                true
        ));
        assessments.add(new TestAssessment(
                IdGenerator.next("A"),
                m18, s3, lec8,
                60, 0.3,
                today.minusDays(12),
                today.plusDays(8),
                20
        ));
        assessments.add(new FinalExamAssessment(
                IdGenerator.next("A"),
                m19, s4, lec9,
                90, 0.6,
                today.minusDays(25),
                today.plusDays(20),
                Duration.ofHours(3),
                15
        ));
        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m20, s5, lec10,
                80, 0.5,
                today.minusDays(22),
                today.plusDays(18),
                false
        ));
        assessments.add(new TestAssessment(
                IdGenerator.next("A"),
                m21, s1, lec6,
                50, 0.4,
                today.minusDays(15),
                today.plusDays(12),
                25
        ));
        assessments.add(new FinalExamAssessment(
                IdGenerator.next("A"),
                m22, s2, lec6,
                85, 0.6,
                today.minusDays(28),
                today.plusDays(22),
                Duration.ofHours(4),
                16
        ));
        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m23, s3, lec6,
                75, 0.5,
                today.minusDays(20),
                today.plusDays(15),
                true
        ));
        assessments.add(new TestAssessment(
                IdGenerator.next("A"),
                m24, s4, lec6,
                65, 0.4,
                today.minusDays(18),
                today.plusDays(10),
                30
        ));
        assessments.add(new FinalExamAssessment(
                IdGenerator.next("A"),
                m25, s5, lec6,
                95, 0.7,
                today.minusDays(30),
                today.plusDays(25),
                Duration.ofHours(5),
                18
        ));
        assessments.add(new AssignmentAssessment(
                IdGenerator.next("A"),
                m26, s1, lec6,
                70, 0.5,
                today.minusDays(25),
                today.plusDays(20),
                false
        ));

        System.out.println("\n Added assessments to list.\n");

        // END OF TEST DATA

        // DEMO OUTPUT


        System.out.println("\n\n== Assessments ==\n");
        
        for (Assessment a : assessments) {
            System.out.println(a.summary()
                    + " | overdue=" + a.isOverdue(today)
                    + " | weighted(achieved=80% of total)="
                    + String.format("%.2f", a.weightedScore((int)(a.getTotalMarks() * 0.8))));
        }

        System.out.println("\n\n== Courses View ==\n");
        
        System.out.println(cs);
        cs.viewCourseModules();
        cs.viewStudents();
        System.out.println("\n\n");

        System.out.println(mths);
        mths.viewCourseModules();
        mths.viewStudents();
        System.out.println("\n\n");

        System.out.println(phy);
        phy.viewCourseModules();
        phy.viewStudents();
        System.out.println("\n\n");


        System.out.println("\n\n== Lecturers View ==\n");
        
        lec1.viewCourseModules();
        lec2.viewCourseModules();
        lec3.viewCourseModules();
        lec4.viewCourseModules();
        lec5.viewCourseModules();
        lec6.viewCourseModules();
        lec7.viewCourseModules();
        lec8.viewCourseModules();
        lec9.viewCourseModules();
        lec10.viewCourseModules();



        System.out.println("\n\nDone.");
    }
}
