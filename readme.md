University Coursework Management System (UCMS) — Exercise 1

Student Name: …  Student ID: …  Date: …

1 Overview

This project implements a simplified University Coursework Management System (UCMS) in Java.
It demonstrates core object-oriented principles — encapsulation, inheritance, polymorphism, abstraction, and composition — through two main components:

Assessment Module – hierarchy of assessment types (Exam, Assignment, Test, Quiz) extending an abstract base class Assessment.

Administration Module – Admin class managing Students, Lecturers, Courses, and Modules.

The program allows an Admin to create users and modules, assign lecturers, and enables lecturers to create and record marks for assessments.

2 Project Structure (Packages)
ucms/
├─ app/           → Main entry point
├─ users/         → User, Student, Lecturer, Admin
├─ courses/       → Course, Module
├─ assessments/   → Assessment (abstract), Exam, Assignment, Test, Quiz
└─ util/          → Repository & helper utilities

3 Key Features

Encapsulation: All fields private; public getters/setters control access.

Inheritance: User → Student, Lecturer, Admin; Assessment → subclasses.

Polymorphism: displayDetails() overridden across assessment types.

Abstraction: Assessment declared abstract; cannot be instantiated directly.

Composition: Admin owns collections of Students, Lecturers, Courses, and Modules.

4 UML Diagrams (in /docs/)
Diagram Name	Description
AssessmentModule.png	Shows abstract Assessment and its concrete subclasses (Exam, Assignment, Test, Quiz) and their association to Module.
AdminRelationships.png	Shows Admin inheritance from User and compositions/associations to Student, Lecturer, Course, Module.
5 Running the Program

Compile the project in IntelliJ IDEA or VS Code.

Run ucms.app.Main.

Console output demonstrates Admin & Lecturer interactions, assessment creation, and mark recording.

6 OOP Highlights
Principle	Example
Encapsulation	Private fields with getters/setters in Assessment.
Inheritance	Admin, Lecturer, Student extend User.
Polymorphism	displayDetails() differs in each subclass of Assessment.
Abstraction	Abstract Assessment defines a generic template.
Composition	Admin “has-a” list of Student, Lecturer, Course, Module.