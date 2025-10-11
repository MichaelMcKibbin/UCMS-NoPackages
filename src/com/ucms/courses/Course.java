package com.ucms.courses;

import com.ucms.users.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * The Course class represents a university course.
 * A course consists of multiple modules and enrolled students.
 */
public class Course {

    // Unique code for the course (e.g., CS)
    private String courseCode;

    // Name of the course (e.g., Computer Science)
    private String courseName;

    // List of modules in the course (composition)
    private List<Module> modules;

    // List of students enrolled in the course (composition)
    private List<Student> students;

    /**
     * Constructor to create a Course object.
     **/
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.modules = new ArrayList<>();
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

    public List<Module> getModules() {
        return modules;
    }

    public List<Student> getStudents() {
        return students;
    }

    /**
     * Adds a module to the course.
     *
     * @param module Module to add
     */
    public void addModule(Module module) {
        modules.add(module);
        System.out.println(module.getModuleName() + " has been added to the course " + courseName);
    }

    /**
     * Enrolls a student in the course.
     *
     * @param student Student to enroll
     */
    public void enrollStudent(Student student) {
        students.add(student);
        System.out.println(student.getFirstname() + " " + student.getLastname() + " has been enrolled in " + courseName);
    }

    /**
     * Displays all modules in the course.
     */
    public void viewModules() {
        System.out.println("Modules for " + courseName + ":");
        for (Module module : modules) {
            System.out.println(module);
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
        return courseCode + " - " + courseName + " (" + students.size() + " students, " + modules.size() + " modules)";
    }
}
