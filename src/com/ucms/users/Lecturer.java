package com.ucms.users;

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
    // List of modules assigned to the lecturer (composition example)
    private List<String> modulesTaught;

    // Constructor to create a Lecturer object.
    // Calls the superclass (User) constructor to set common attributes.
    public Lecturer(String firstname, String lastname, String email, String password,
                    String address, String phone, String lecturerId, String department) {
        super(firstname, lastname, email, password, address, phone);
        this.lecturerId = lecturerId;
        this.department = department;
        // Initialize the list of modules. Find out the difference between Array and ArrayList
        this.modulesTaught = new ArrayList<>();
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

    public List<String> getModulesTaught() {
        return modulesTaught;
    }

    // Assigns a new module to the lecturer.
    public void assignModule(String moduleName) {
        modulesTaught.add(moduleName);
        System.out.println(getFirstname() + " is now assigned to teach " + moduleName);
    }

    // Displays all modules currently taught by the lecturer.
    public void viewModules() {
        System.out.println("Modules taught by " + getFirstname() + ": " + modulesTaught);
    }

    // Overrides the default toString() method to provide meaningful output for Lecturer objects.
    @Override
    public String toString() {
        return "Lecturer: " + getFirstname() + " " + getLastname() + " (" + lecturerId + ")";
    }
}

