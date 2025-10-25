package com.ucms.domain;

public class Student extends User {
    // Unique ID assigned to the student
    private String studentId;

    // Course the student is enrolled in
    private String course;

    // Student's Grade Point Average
    private double gpa;

    //  Constructor to create a Student object.
    //  Calls the superclass (User) constructor to set common attributes.

    public Student(String firstname, String lastname, String email, String password,
                   String address, String phone, String studentId, String course, double gpa) {
        super(firstname, lastname, email, password, address, phone);
        this.studentId = studentId;
        this.course = course;
        this.gpa = gpa;
    }

    // Getter and Setter methods for encapsulated fields
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void enrollCourse(String courseName) {
        System.out.println(getFirstname() + " has enrolled in " + courseName);
    }

    // Displays the student's current GPA.
    public void viewResults() {
        System.out.println(getFirstname() + " has a GPA of " + gpa);
    }

    // Overrides the default toString() method to provide meaningful output for Student objects.
    @Override
    public String toString() {
        return "Student: " + getFirstname() + " " + getLastname() + " (" + studentId + ")";
    }
}
