package com.ucms.courses;

import com.ucms.users.Lecturer;

/**
 * The Module class represents an academic module within a course.
 * Each module has a unique code, a name, and is associated with a lecturer.
 */
public class Module {

    // Unique code for the module (e.g., CS101)
    private String moduleCode;

    // Name of the module (e.g., Introduction to Programming)
    private String moduleName;

    // Lecturer assigned to teach the module (composition)
    private Lecturer lecturer;


    // Constructor to create a Module object.
    public Module(String moduleCode, String moduleName, Lecturer lecturer) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.lecturer = lecturer;
    }

    // Getter and Setter methods
    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return moduleCode + " - " + moduleName + " (Lecturer: " + lecturer.getFirstname() + " " + lecturer.getLastname() + ")";
    }
}
