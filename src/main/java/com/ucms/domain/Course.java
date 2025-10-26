package com.ucms.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * The Course class represents a university course.
 * A course consists of multiple courseModules and enrolled students.
 */
public class Course {

    // Unique code for the course (e.g., CS)
    private String courseCode;

    // Name of the course (e.g., Computer Science)
    private String courseName;

    // List of courseModules in the course (composition)
    private List<CourseModule> courseModules;

    // List of students enrolled in the course (composition)
    private List<Student> students;

    /**
     * Constructor to create a Course object.
     **/
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseModules = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<CourseModule> getCourseModules() {
        return courseModules;
    }

    public List<Student> getStudents() {
        return students;
    }

    /**
     * Adds a courseModule to the course.
     *
     * @param courseModule CourseModule to add
     */
    public void addCourseModule(CourseModule courseModule) {
        courseModules.add(courseModule);
        System.out.println(courseModule.getCourseModuleName() + " has been added to the course " + courseName);
    }

    /**
     * Enrolls a student in the course.
     *
     * @param student Student to enroll
     */
    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.setCourse(String.valueOf(this));
            System.out.println(student.getFirstname() + " " + student.getLastname() + " has been enrolled in " + courseName);
        }
    }

    /**
     * Displays all courseModules in the course.
     */
    public void viewCourseModules() {
        System.out.println("Course Modules for " + courseName + ":");
        for (CourseModule courseModule : courseModules) {
            System.out.println(courseModule);
        }
    }

    /**
     * Displays all students enrolled in the course.
     */
    public void viewStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName + " (" + students.size() + " students, " + courseModules.size() + " courseModules)";
    }
}
