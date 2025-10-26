package com.ucms.assessment;

import com.ucms.domain.*;
import java.time.LocalDate;

/** Concrete assessment: Assignment (submission-based). */
public class AssignmentAssessment extends com.ucms.assessment.Assessment {
    private final boolean requiresSubmissionLink;

    public AssignmentAssessment(
            String id,
            CourseModule courseModule,
            Student student,
            Lecturer lecturer,
            int totalMarks,
            double weight,
            LocalDate assignedDate,
            LocalDate dueDate,
            boolean requiresSubmissionLink) {

        super(id, courseModule, student, lecturer, totalMarks, weight, assignedDate, dueDate);
        this.requiresSubmissionLink = requiresSubmissionLink;
    }

    @Override
    public AssessmentType getType() { return AssessmentType.ASSIGNMENT; }

    public boolean isRequiresSubmissionLink() { return requiresSubmissionLink; }

    @Override
    public String summary() {
        return super.summary() + " | requiresLink=" + requiresSubmissionLink;
    }
}
