package com.ucms;

/**
 * The CourseModule class represents an academic module within a course.
 * Each module has a unique code, a name, and is associated with a lecturer.
 */
public class CourseModule {

    // Unique code for the module (e.g., CS101)
    private String courseModuleCode;

    // Name of the module (e.g., Introduction to Programming)
    private String courseModuleName;

    // Lecturer assigned to teach the module (composition)
    private Lecturer lecturer;


     // Constructor to create a CourseModule object.
    public CourseModule(String courseModuleCode, String courseModuleName, Lecturer lecturer) {
        this.courseModuleCode = courseModuleCode;
        this.courseModuleName = courseModuleName;
        this.lecturer = lecturer;
    }

    // Getter and Setter methods
    public String getCourseModuleCode() {
        return courseModuleCode;
    }

    public void setCourseModuleCode(String courseModuleCode) {
        this.courseModuleCode = courseModuleCode;
    }

    public String getCourseModuleName() {
        return courseModuleName;
    }

    public void setCourseModuleName(String courseModuleName) {
        this.courseModuleName = courseModuleName;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }



    @Override
    public String toString() {
        return courseModuleCode + " - " + courseModuleName + " (Lecturer: " + lecturer.getFirstname() + " " + lecturer.getLastname() + ")";
    }
}
