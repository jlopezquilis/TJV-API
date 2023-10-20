# TJV Project

## DESCRIPTION OF THE DATA

----------------------------------------
|               Student                |
----------------------------------------
| - id : int                           |
| - name : string                      |
| - age : int                          |
----------------------------------------
| + enroll(course: Course) : void      |
| + disenroll(course: Course) : void   |
----------------------------------------
               0..* |
                    |
                    |
                    |
                    |
                    |
                    |
                    | 0..*
----------------------------------------------
|                 Course                     |
----------------------------------------------
| - id : int                                 |
| - name : string                            |
| - credits : int                            |
| - capacity : int                           |
----------------------------------------------
| + assignTeacher(teacher: Teacher) : void   |
| + obtainTeacher() : Teacher                |
| + addStudent(student: Student) : void      |
| + deleteStudent(student: Student) : void   |
| + obtainStudents() : Student[]             |
----------------------------------------------
               0..* |
                    |
                    |
                    |
                    |
                    |
                    |
                    | 0..1
------------------------------------------
|             Teacher                    |
------------------------------------------
| - id : int                             |
| - name : string                        |
| - department : string                  |
------------------------------------------
| + assignCourse(course: Course) : void  |
| + obtainCourses() : Course[]           |
------------------------------------------

## DESCRIPTION OF THE COMPLEX QUERY
Two options for the complex query:
1) Get the total number of enrolled credits for a student
2) Given a Teacher, get all the students that are being taught by her/him (a Teacher can teach in more than one course).

## DESCRIPTION OD THE COMPLEX BUSINESS LOGIC INFORMATION
The client (a student) will be able to enroll in a course. When the student will press the button "enroll", the system will check if there exists the course and if there is free capacity. If all the statements are acomplished, the client will get a message confirming the enrollment, otherwise will get a message saying that the student can not enroll in that course and the reason.