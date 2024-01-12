package cz.cvut.fit.tjv.project.tjvapi.controller.unitTests;
import cz.cvut.fit.tjv.project.tjvapi.controllers.StudentController;
import cz.cvut.fit.tjv.project.tjvapi.entities.Student;
import cz.cvut.fit.tjv.project.tjvapi.services.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class StudentControllerUnitTest {
    @MockBean
    private StudentService studentService;
    @Autowired
    private StudentController studentController;

    private Student student1, student2;

    @BeforeEach
    void setUp() {
        // Setup test data
        student1 = new Student();
        student1.setId(1);
        student1.setName("John Doe");

        student2 = new Student();
        student2.setId(2);
        student2.setName("Jane Doe");

        // Setup mock behavior
        Mockito.when(studentService.readByCourses_Id(1))
                .thenReturn(Arrays.asList(student1, student2)); // Returns List<Student>
        Mockito.when(studentService.readByName("John Doe"))
                .thenReturn(Arrays.asList(student1)); // Returns List<Student>
        Mockito.when(studentService.obtainTotalEnrolledCredits(1))
                .thenReturn(10); // Returns Integer

        // Handling cases where the student or course is not found
        Mockito.when(studentService.readByCourses_Id(3)).thenThrow(ResponseStatusException.class); // Return empty list if not found
        Mockito.when(studentService.readByName("Unknown")).thenThrow(ResponseStatusException.class); // Return empty list if not found
        Mockito.when(studentService.obtainTotalEnrolledCredits(3)).thenThrow(ResponseStatusException.class); // Return null if not found
    }

    @Test
    void readByCourses_Id_Found() {
        Collection<Student> students = studentController.readByCourses_Id(1);
        Assertions.assertFalse(students.isEmpty());
        Assertions.assertTrue(students.contains(student1));
        Assertions.assertTrue(students.contains(student2));
    }

    @Test
    void readByCourses_Id_NotFound() {
        Assertions.assertThrows(
                ResponseStatusException.class,
                () -> studentController.readByCourses_Id(3)
        );
    }

    @Test
    void obtainTotalEnrolledCredits_Found() {
        int credits = studentController.obtainTotalEnrolledCredits(1);
        Assertions.assertEquals(10, credits);
    }

    @Test
    void obtainTotalEnrolledCredits_NotFound() {
        Assertions.assertThrows(
                ResponseStatusException.class,
                () -> studentController.obtainTotalEnrolledCredits(3)
        );
    }

    @Test
    void getCourseIdByName_Found() {
        Collection<Student> students = studentController.getCourseIdByName("John Doe");
        Assertions.assertFalse(students.isEmpty());
        Assertions.assertTrue(students.contains(student1));
    }

    @Test
    void getCourseIdByName_NotFound() {
        Assertions.assertThrows(
                ResponseStatusException.class,
                () -> studentController.getCourseIdByName("Unknown")
        );
    }
}
