package com.ucms;

import java.time.LocalDate;

/** Concrete assessment: Test (shorter than final). */
public class TestAssessment extends Assessment {
    private final int numberOfQuestions;

    public TestAssessment(
            String id,
            CourseModule module,
            Student student,
            Lecturer lecturer,
            int totalMarks,
            double weight,
            LocalDate assignedDate,
            LocalDate dueDate,
            int numberOfQuestions) {

        super(id, module, student, lecturer, totalMarks, weight, assignedDate, dueDate);
        this.numberOfQuestions = numberOfQuestions;
    }

    @Override
    public AssessmentType getType() { return AssessmentType.TEST; }

    public int getNumberOfQuestions() { return numberOfQuestions; }

    @Override
    public String summary() {
        return super.summary() + " | questions=" + numberOfQuestions;
    }
}