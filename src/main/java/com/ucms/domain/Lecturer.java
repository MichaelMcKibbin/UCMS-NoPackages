package com.ucms.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * The Lecturer class represents a lecturer user in the system.
 * It extends the User class and includes lecturer-specific attributes and behaviors.
 */

public class Lecturer extends User {
    // Unique ID assigned to the lecturer
    private String lecturerId;
    // Department the lecturer belongs to
    private String department;
    // List of courseModules assigned to the lecturer (composition example)
    private List<String> courseModulesTaught;

    // Constructor to create a Lecturer object.
    // Calls the superclass (User) constructor to set common attributes.
    public Lecturer(String firstname, String lastname, String email, String password,
                    String address, String phone, String lecturerId, String department) {
        super(firstname, lastname, email, password, address, phone);
        this.lecturerId = lecturerId;
        this.department = department;
        // Initialize the list of courseModules. Find out the difference between Array and ArrayList
        this.courseModulesTaught = new ArrayList<>();
    }

    // Getter and Setter methods for encapsulated fields
    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getCourseModulesTaught() {
        return courseModulesTaught;
    }

    // Assigns a new courseModule to the lecturer.
    public void assignCourseModule(String courseModuleName) {
        courseModulesTaught.add(courseModuleName);
        System.out.println(getFirstname() + " is now assigned to teach " + courseModuleName);
    }

    // Displays all courseModules currently taught by the lecturer.
    public void viewCourseModules() {
        System.out.println("Course Modules taught by " + getFirstname()+" "  + getLastname() +": " + courseModulesTaught);
    }

    // Overrides the default toString() method to provide meaningful output for Lecturer objects.
    @Override
    public String toString() {
        return "Lecturer: " + getFirstname() + " " + getLastname() + " (" + lecturerId + ")";
    }
}
