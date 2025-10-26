package com.ucms;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Abstract base for all assessments.
 * Holds common fields + core behaviors required by the brief.
 */
public abstract class Assessment {
    private final String id;         // unique
    private final CourseModule courseModule;     // courseModule this assessment belongs to
    private final Student student;   // who takes it
    private final Lecturer lecturer; // who sets/grades it

    private final int totalMarks;    // e.g., 100
    private final double weight;     // 0..1 (e.g., 0.6 == 60%)
    private final LocalDate assignedDate;
    private final LocalDate dueDate; // for exams, treat as exam date too

    private LocalDate takenDate;     // null until sat/submitted

    protected Assessment(
            String id,
            CourseModule courseModule,
            Student student,
            Lecturer lecturer,
            int totalMarks,
            double weight,
            LocalDate assignedDate,
            LocalDate dueDate) {

        if (totalMarks <= 0) throw new IllegalArgumentException("totalMarks must be > 0");
        if (weight < 0 || weight > 1) throw new IllegalArgumentException("weight must be in [0,1]");
        this.id = Objects.requireNonNull(id, "id");
        this.courseModule = Objects.requireNonNull(courseModule, "courseModule");
        this.student = Objects.requireNonNull(student, "student");
        this.lecturer = Objects.requireNonNull(lecturer, "lecturer");
        this.totalMarks = totalMarks;
        this.weight = weight;
        this.assignedDate = Objects.requireNonNull(assignedDate, "assignedDate");
        this.dueDate = Objects.requireNonNull(dueDate, "dueDate");
    }

    public abstract AssessmentType getType();

    /** Simple human-readable one-liner. */
    public String summary() {
        return String.format(
                "[%s] id=%s | courseModule=%s | student=%s %s | total=%d | weight=%.0f%% | due=%s | taken=%s",
                getType(),
                id,
                courseModule.toString(),
                student.getFirstname(), student.getLastname(),
                totalMarks,
                weight * 100.0,
                dueDate,
                takenDate == null ? "-" : takenDate.toString()
        );
    }

    /** True if after due date and not yet taken/submitted. */
    public boolean isOverdue(LocalDate today) {
        return takenDate == null && today.isAfter(dueDate);
    }

    /** Returns weighted percentage in [0,100] for the achieved raw marks. */
    public double weightedScore(int achievedMarks) {
        if (achievedMarks < 0 || achievedMarks > totalMarks) {
            throw new IllegalArgumentException("achievedMarks out of range 0.." + totalMarks);
        }
        double rawPct = achievedMarks / (double) totalMarks;  // 0..1
        return rawPct * (weight * 100.0);
    }

    // --- Getters / minimal setters ---
    public String getId() { return id; }
    public CourseModule getCourseModule() { return courseModule; }
    public Student getStudent() { return student; }
    public Lecturer getLecturer() { return lecturer; }
    public int getTotalMarks() { return totalMarks; }
    public double getWeight() { return weight; }
    public LocalDate getAssignedDate() { return assignedDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getTakenDate() { return takenDate; }
    public void setTakenDate(LocalDate takenDate) { this.takenDate = takenDate; }

    @Override public String toString() { return summary(); }
}
