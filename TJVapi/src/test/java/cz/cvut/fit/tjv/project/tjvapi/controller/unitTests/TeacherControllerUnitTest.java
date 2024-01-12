package cz.cvut.fit.tjv.project.tjvapi.controller.unitTests;

import cz.cvut.fit.tjv.project.tjvapi.controllers.TeacherController;
import cz.cvut.fit.tjv.project.tjvapi.entities.Student;
import cz.cvut.fit.tjv.project.tjvapi.entities.Teacher;
import cz.cvut.fit.tjv.project.tjvapi.services.TeacherService;
import cz.cvut.fit.tjv.project.tjvapi.services.exceptions.EntityCannotBeCreatedException;
import cz.cvut.fit.tjv.project.tjvapi.services.exceptions.EntityDoesNotExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@SpringBootTest
class TeacherControllerUnitTest {
    @MockBean
    private TeacherService teacherService;
    @Autowired
    private TeacherController teacherController;

    private Teacher teacher1, teacher2;
    private Student student1, student2;

    @BeforeEach
    void setUp() {
        teacher1 = new Teacher();
        teacher1.setId(1);
        teacher1.setName("Alice Smith");

        teacher2 = new Teacher();
        teacher2.setId(2);
        teacher2.setName("Bob Johnson");

        student1 = new Student();
        student1.setId(1);
        student1.setName("John Doe");

        student2 = new Student();
        student2.setId(2);
        student2.setName("Jane Doe");

        Mockito.when(teacherService.readByDepartment("Mathematics"))
                .thenReturn(Arrays.asList(teacher1, teacher2));
        Mockito.when(teacherService.obtainStudentsTaughtByTeacher(1))
                .thenReturn(Arrays.asList(student1, student2));
        Mockito.when(teacherService.readByName("Alice Smith"))
                .thenReturn(Arrays.asList(teacher1));
    }

    @Test
    void readByDepartment_Found() {
        Collection<Teacher> teachers = teacherController.readByDepartment("Mathematics");
        Assertions.assertFalse(teachers.isEmpty());
        Assertions.assertTrue(teachers.contains(teacher1));
        Assertions.assertTrue(teachers.contains(teacher2));
    }

    @Test
    void obtainStudentsTaughtByTeacher_Found() {
        Collection<Student> students = teacherController.obtainStudentsTaughtByTeacher(1);
        Assertions.assertFalse(students.isEmpty());
        Assertions.assertTrue(students.contains(student1));
        Assertions.assertTrue(students.contains(student2));
    }

    @Test
    void getCourseIdByName_Found() {
        Collection<Teacher> teachers = teacherController.getCourseIdByName("Alice Smith");
        Assertions.assertFalse(teachers.isEmpty());
        Assertions.assertTrue(teachers.contains(teacher1));
    }

    // Add tests for not found cases
    @Test
    void readByDepartment_NotFound() {
        Mockito.when(teacherService.readByDepartment("History")).thenThrow(ResponseStatusException.class);
        Assertions.assertThrows(
                ResponseStatusException.class,
                () -> teacherController.readByDepartment("History")
        );
    }

    @Test
    void obtainStudentsTaughtByTeacher_NotFound() {
        Mockito.when(teacherService.obtainStudentsTaughtByTeacher(3)).thenThrow(ResponseStatusException.class);
        Assertions.assertThrows(
                ResponseStatusException.class,
                () -> teacherController.obtainStudentsTaughtByTeacher(3)
        );
    }

    @Test
    void getCourseIdByName_NotFound() {
        Mockito.when(teacherService.readByName("Unknown")).thenThrow(ResponseStatusException.class);
        Assertions.assertThrows(
                ResponseStatusException.class,
                () -> teacherController.getCourseIdByName("Unknown")
        );
    }
}

