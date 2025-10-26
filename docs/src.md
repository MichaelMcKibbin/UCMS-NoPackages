```mermaid
classDiagram
direction BT

class Admin
class Student
class User
class Lecturer
class Course
class CourseModule
class Assessment
class FinalExam
class TestAssessment
class AssignmentAssessment
class Main
class AssessmentType

User <|-- Admin
User <|-- Student
User <|-- Lecturer


Course "1" --> "*" CourseModule
Course "1" --> "*" Student
CourseModule "1" --> "1" Lecturer

Assessment <|-- TestAssessment
Assessment <|-- AssignmentAssessment
Assessment <|-- FinalExam

Main ..> Admin : uses
Main ..> Assessment : polymorphism
Main ..> Course
Main ..> CourseModule
Main ..> Student
Main ..> Lecturer

```