# University Coursework Management System (UCMS) — (Revised) Exercise 1 

**Student Name:** Michael McKibbin<br>
**Module:** Software Development<br> 
**Module Code:** SWDE_IT803 - LY_ICSWD_B 2025/2026<br>
**Lecturer:** Lusungu Mwasinga<br>
**Date:** 26th October 2025<br>

---

## 1. Overview

This project implements the revised version of Exercise 1, the **University Coursework Management System (UCMS)** in Java.  
### Objective: 
To apply and demonstrate **Object-Oriented Programming (OOP)** principles through the design and implementation of a University Coursework Management System in Java.

The system demonstrates core Object-Oriented Programming (OOP) principles — *encapsulation, inheritance, polymorphism, abstraction,* and *composition* — through three main components:

1. **Assessment Module** – an abstract base class `Assessment` and three concrete subclasses:  
   - `FinalExamAssessment`, 
   - `TestAssessment`, and 
   - `AssignmentAssessment`.
   
   Each assessment records details such as ID, student, module, lecturer, total marks, weight, assigned/due dates, and provides behaviours for displaying details, checking overdue status, and calculating weighted scores. 
   <br><br>
2. **Administration Module** – the `Admin` class extends `User` and includes multiple constructors demonstrating **constructor chaining**. Linking the no-argumant, partial, and full constructors, ensures that all initialisation follows the same logic path resulting in consistent object set-up.    
   Manages in-memory collections of students, lecturers, courses, and course modules, supporting actions such as:
    - Adding/removing students and lecturers
    - Creating courses
    - Adding course modules to courses
    - Assigning course modules to lecturers
      <br><br>   
3. **Main Application** – Demonstrates realistic interactions between users, showing the relationships and operations among `Admin`, `Lecturer`, `Student`, `Course`, `CourseModule`, and various assessments.

---

## 2. Project Structure (No Packages)

Note: This version was refactored to remove sub-packages for simplicity. All classes now reside in the default project directory, but maintain their logical groupings as shown in the UML diagrams.

<!--
Using packages to group real-world models together:


| Package              | Purpose                                                         |
|:---------------------|:----------------------------------------------------------------|
| com.ucms.domain      | Core business entities (students, lecturers, courses, modules)  |
| com.ucms.assessment  | Logic for coursework and grading                                |
| com.ucms.admin       | Management operations (user/course handling)                    |
| com.ucms.support     | Utility classes (e.g., IdGenerator)                             |                                                                                    
| com.ucms.app         | Application entry point and runtime coordination                |                                                                                    

```
com/ucms/
    ├─ admin/ → Admin (extends User)
    ├─ app/ → Main entry point (Main.java)
    ├─ assessment/ → Assessment (abstract), AssessmentType, AssignmentAssessment, FinalExamAssessment, TestAssessment 
    ├─ domain/ → Course, CourseModule, Lecturer, Student, User 
    └─ support/ → IdGenerator
```
-->
---

## 3. Key Features
The table below summarises the main object-oriented principles and design features demonstrated in the project.

| Principle                    | Description                                                                                                                                        |
|:-----------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------|
| **Encapsulation**            | All fields are private; getters/setters control access to data.                                                                                    |
| **Inheritance**              | `User` is extended by `Student`, `Lecturer`, and `Admin`; `Assessment` is extended by concrete subclasses.                                         |
| **Polymorphism**             | A single `List<Assessment>` holds mixed assessment types; each subclass overrides `summary()` to display its own details.                          |
| **Abstraction**              | `Assessment` is abstract and cannot be instantiated directly.                                                                                      |
| **Composition**              | A `Course` contains multiple `CourseModule` objects and enrolled `Student`s; `CourseModule` references a `Lecturer`; `Admin` manages all entities. |
| **Constructor Chaining**     | Demonstrated in the `Admin` class with multiple constructors calling `this(...)`.                                                                  |
| **Strong Typing with Enums** | Prevents invalid data entry, improves code reliability, and ensures compile-time checking of assessment types.                                    |


---

## 4. UML Diagrams 
The following diagrams and images are stored in the `/docs/` folder.

| Diagram                               | Description                                                                                                                                                                                      |
|:--------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **AssessmentModuleClass.png**         | Shows the abstract `Assessment` class and its three concrete subclasses (`FinalExamAssessment`, `TestAssessment`, `AssignmentAssessment`), with associations to `CourseModule`, `Student`, and `Lecturer`. |
| **AssessmentModuleRelationships.png** | Shows the relationship hierarchy of the `Assessment` class.                                                                                                                                      |
| **AdminRelationships.png**            | Shows `Admin` inheriting from `User` and its associations to `Student`, `Lecturer`, `Course`, and `CourseModule`.                                                                                |
| **MainSimulation.png**                | Illustrates how the `Main` class coordinates the simulation, highlighting object interactions and polymorphic assessment handling.                                                               |
| **ClassModel.png**                    | The complete UML Class Diagram - the 'AssessmentModuleClass' was extracted from this diagram                                                                                                     |
| **ucms.puml**                         | PlantUML source file for the complete UML class diagram.                                                                                                                                         |
| **src.md**                            | Mermaid UML class diagram source file.                                                                                                                                                           |


### Figure 1 — Assessment Class
The Assessment Class Diagram illustrates the inheritance and composition relationships that define the assessment subsystem of the UCMS. <br>
The abstract Assessment class provides a shared structure and behaviour for all assessment types, while its concrete subclasses (FinalExamAssessment, TestAssessment, and AssignmentAssessment) specialise that behaviour through unique attributes such as duration, number of questions, or submission requirements. <br>
Associations to CourseModule, Student, and Lecturer demonstrate composition and contextual linkage—each assessment belongs to a module, is assigned by a lecturer, and is taken by a student. This design effectively demonstrates inheritance, abstraction, and composition in practice, ensuring extensibility for future assessment types.
<p style="text-align: center;">
  <img src="docs/AssessmentClass.png" alt="Assessment Module Class UML" width="600"><br>
  <em>Figure 1: Assessment module class hierarchy showing the abstract <code>Assessment</code> class and its three concrete subclasses (<code>FinalExamAssessment</code>, <code>TestAssessment</code>, and <code>AssignmentAssessment</code>) with associations to <code>CourseModule</code>, <code>Student</code>, and <code>Lecturer</code>.</em>
</p>

### Figure 2 — Main Simulation Diagram
<p style="text-align: center;">
  <img src="docs/MainSimulation.png" alt="Main Simulation Diagram" width="600"><br>
  <em>Figure 2: Main simulation sequence diagram demonstrating how <code>Main</code> coordinates user interactions and polymorphic assessment handling.</em>
</p>

### Figure 3 — Admin Relationships
<p style="text-align: center">
  <img src="docs/AdminRelationships.png" alt="Admin Relationships UML" width="600"/><br>
  <em>Figure 3: Admin class relationships with User, Student, Lecturer, and CourseModule.</em>
</p>

### Figure 4 — Class Model
The complete UCMS Class Model presents the full architecture of the system, integrating all major entities and their relationships. <br>
It highlights the three primary inheritance hierarchies—User (extended by Admin, Lecturer, and Student), Assessment (extended by the specific assessment types), and the enum AssessmentType. <br>
The diagram also shows how composition and aggregation connect the academic structures: 
- A Course contains multiple CourseModule objects, 
- each linked to a Lecturer and 
- associated with enrolled Students. 

Administrative operations, represented by the Admin class, coordinate these relationships and demonstrate encapsulated management of data. The Main class acts as the entry point, orchestrating interactions and demonstrating polymorphism through the Assessment hierarchy. <br>
Overall, the model conveys a cohesive object-oriented design that balances inheritance for reuse with composition for realistic domain modelling.

<p style="text-align: center">
  <img src="docs/ClassModelNoPackages.png" alt="Class Model UML" width="600"/><br>
  <em>Figure 4: Detailed UML class Diagram.</em>
</p>

---

## 5. Procedure (Running the Program)

1. Open the project
- Launch your preferred IDE (e.g. IntelliJ IDEA or Eclipse).
- Open the project folder or import the Maven project (pom.xml) to ensure all dependencies and source paths load correctly.
- Verify that the JDK 17 (or any Java 8 +) runtime is selected.

2. Run the main class
- Locate and run Main.java (package com.ucms.app or root folder if using the no-package version).
- The program can be run directly from the IDE’s Run button or via the command line using:
```
java com.ucms.Main
```

3. Observe the console output
The program demonstrates:
- Admin creation and constructor chaining
- Adding/removing students and lecturers
- Creating courses and assigning course modules
- Lecturer–student–assessment relationships
- Polymorphic assessment iteration and output
- Overdue status and weighted score calculations

Expected result:
The console displays meaningful messages showing the entities created and the actions performed.

---

## 6. OOP Highlights

| Principle                 | Example                                                                                                                   |
|:--------------------------|:--------------------------------------------------------------------------------------------------------------------------|
| **Encapsulation**         | Private fields with getters/setters in `CourseModule` and `Assessment`.                                                   |
| **Inheritance**           | `Admin`, `Lecturer`, `Student` extend `User`; `FinalExamAssessment`, `TestAssessment`, `AssignmentAssessment` extend `Assessment`.  |
| **Polymorphism**          | `for (Assessment a : assessments)` iterates through multiple types with overridden `summary()` methods.                   |
| **Abstraction**           | `Assessment` defines shared structure and abstract behaviour for its subclasses.                                          |
| **Composition**           | `Course` “has-a” list of `CourseModule` and `Student`; `CourseModule` “has-a” `Lecturer`.                                 |
| **Constructor Chaining**  | `Admin` provides three constructors calling each other with `this(...)`.                                                  |

---

## 7. Notes on Revisions

- **De-packaged this version** For simplicity, the project was de-packaged to a single root package.
- **Renamed `Module` → `CourseModule`** to avoid conflict with `java.lang.Module` and improve clarity.
- **Simplified “Quiz” and “Test”** into a single unified `TestAssessment` class. ('Quiz' is not mentioned in revised requirements).
- **Consolidated Admin operations** to manage data using in-memory `List<>` structures. (No db).
- **Main simulation** redesigned to show constructor chaining, encapsulation, and polymorphism with practical console outputs.

---

## 8. Technologies Used

- **Language:** Java 21 (Uses only *core Java8+ syntax*. Compatible with *Java 8, 11, 17, \& 21*.)
- **Build IDE:** IntelliJ IDEA 2025.2
- **Build Tool:** Maven 3.13.0
- **Testing:** JUnit 5.12.1 for lightweight validation
- **Diagrams:** PlantUML / IntelliJ UML tool

---

## 9. Author

> **Name:** Michael McKibbin  
> **Course:** B.Sc. (Hons) in Contemporary Software Development  
> **Institution:** Atlantic Technological University (ATU)  
> **Year:** 2025/2026  
> **Exercise:** UCMS – Revised Exercise 1 - No Packages

---

## 10. Design Rationale

The revised UCMS design prioritises clarity, consistency, and maintainability, while demonstrating the core principles of encapsulation, inheritance, and polymorphism in a cohesive and extensible object-oriented structure.

The design was guided by the goals of Exercise 1: to produce a modular, well-structured system that models realistic academic relationships between users, courses, and assessments.

Renaming the original Module class to CourseModule eliminated a potential naming conflict with java.lang.Module and clarified the class’s specific role within a Course. Although it was technically possible to retain the original name, using imports, doing so risked confusion between UCMS domain classes and Java system classes. The updated naming convention enhances readability and reinforces clear semantic intent throughout the codebase.

Administrative functionality was consolidated within a single Admin class, using in-memory collections (List<>) to manage entities such as students, lecturers, and courses. This approach reduces redundancy, simplifies maintenance, and provides a flexible foundation that could later be extended to persistent storage without structural changes.

Since references to 'Quiz' were removed in the revised specifications, the assessment hierarchy was streamlined from four classes to three — FinalExamAssessment, TestAssessment, and AssignmentAssessment — each extending a shared abstract superclass Assessment. 
These demonstrate inheritance and polymorphism while ensuring that common logic is defined once and reused across all assessment types.

Constructor chaining in the Admin class promotes code reuse and consistent object initialisation, while composition between Course, CourseModule, and Lecturer models “has-a” relationships that mirror real-world associations. Encapsulation is reinforced through the use of private fields and controlled accessors, preserving data integrity and supporting future scalability.

Overall, this iteration delivers a cleaner and more maintainable architecture with clear package separation, logical class interactions, and console output that effectively demonstrates the intended OOP behaviours. The design achieves the educational objectives of the exercise by integrating theoretical principles into a practical and verifiable implementation.