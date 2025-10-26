package com.ucms.admin;

import com.ucms.domain.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Admin user with basic management actions over in-memory lists.
 * Demonstrates constructor chaining and simple CRUD-like operations.
 */
public class Admin extends User {
    private final String role;
    private final LocalDate createdAt;

    private String adminName() {
        String f = getFirstname();
        String l = getLastname();
        String name =
                ((f == null || f.isBlank()) && (l == null || l.isBlank()))
                        ? "Admin"
                        : ( ((f == null) ? "" : f.trim()) + " " + ((l == null) ? "" : l.trim()) ).trim();
        return "[Admin: " + name + "]";
    }


    // 1) no-arg style (minimal defaults) – calls the full constructor (super)
    public Admin() {
        this("Admin", "User", "admin@example.com", "changeme", "N/A", "N/A",
                "ADMIN", LocalDate.now());
    }

    // 2) partial - chains to full constructor
    public Admin(String firstname, String lastname, String email) {
        this(firstname, lastname, email, "changeme", "N/A", "N/A",
                "ADMIN", LocalDate.now());
    }

    // 3) full – calls super
    public Admin(String firstname, String lastname, String email, String password,
                 String address, String phone, String role, LocalDate createdAt) {
        super(firstname, lastname, email, password, address, phone);
        this.role = role == null ? "ADMIN" : role;
        this.createdAt = createdAt == null ? LocalDate.now() : createdAt;
    }

    public String getRole() { return role; }
    public LocalDate getCreatedAt() { return createdAt; }

    // --- Student management ---
    public void addStudent(List<Student> repo, Student s) {
        repo.add(s);
        System.out.println(adminName()+ " "+" Added student: " + s);
    }

    public boolean removeStudent(List<Student> repo, String studentId) {
        return repo.removeIf(stu -> studentId != null && studentId.equals(stu.getStudentId()));
    }

    // --- Lecturer management ---
    public void addLecturer(List<Lecturer> repo, Lecturer l) {
        repo.add(l);
        System.out.println(adminName()+ " "+" Added lecturer: " + l);
    }

    public boolean removeLecturer(List<Lecturer> repo, String lecturerId) {
        // You can add a getLecturerId() to Lecturer to make this cleaner if not present.
        return repo.removeIf(lec -> lecturerId != null && lecturerId.equals(lec.toString()));
    }

    // --- Course / CourseModule management ---
    public void createCourse(List<Course> repo, Course c) {
        repo.add(c);
        System.out.println(adminName()+ " "+" Created course: " + c);
    }

    public void addCourseModuleToCourse(Course c, CourseModule m) {
        c.addCourseModule(m); // uses your Course.addCourseModule(CourseModule)
        System.out.println(adminName()+ " "+" Added module " + m + " to course " + c);
    }

    public void assignCourseModuleToLecturer(CourseModule m, Lecturer l) {
        m.setLecturer(l);  // uses your CourseModule.setLecturer(Lecturer)
        l.assignCourseModule(m.getCourseModuleName()); // uses your Lecturer.assignCourseModule(String)
        System.out.println(adminName()+ " "+" Assigned " + m + " to lecturer " + l);
    }

    // --- Optional lookups ---
    public Optional<Student> findStudentById(List<Student> repo, String studentId) {
        return repo.stream().filter(s -> studentId.equals(s.getStudentId())).findFirst();
    }

    public Optional<Lecturer> findLecturerById(List<Lecturer> repo, String lecturerId) {
        return repo.stream().filter(l -> lecturerId.equals(l.toString())).findFirst();
    }


}