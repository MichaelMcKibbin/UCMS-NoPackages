package com.ucms.assessment;

import com.ucms.assessment.*;
import com.ucms.domain.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

/** Concrete assessment: Final Exam. */
public class FinalExam extends com.ucms.assessment.Assessment {
    private final Duration duration;        // e.g., 2h
    private final int numberOfQuestions;    // optional field

    public FinalExam(
            String id,
            CourseModule module,
            Student student,
            Lecturer lecturer,
            int totalMarks,
            double weight,
            LocalDate assignedDate,
            LocalDate examDate,             // use as dueDate
            Duration duration,
            int numberOfQuestions) {

        super(id, module, student, lecturer, totalMarks, weight, assignedDate, examDate);
        this.duration = Objects.requireNonNull(duration, "duration");
        this.numberOfQuestions = numberOfQuestions;
    }

    @Override
    public AssessmentType getType() { return AssessmentType.FINAL_EXAM; }

    public Duration getDuration() { return duration; }
    public int getNumberOfQuestions() { return numberOfQuestions; }

    @Override
    public String summary() {
        return super.summary() + String.format(" | duration=%s | questions=%d",
                duration, numberOfQuestions);
    }
}
