package cz.cvut.fit.tjv.project.tjvapi.controller;

import cz.cvut.fit.tjv.project.tjvapi.controllers.CourseController;
import cz.cvut.fit.tjv.project.tjvapi.entities.Course;
import cz.cvut.fit.tjv.project.tjvapi.services.CourseService;
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
class CourseControllerUnitTest {
    @MockBean
    private CourseService courseService;
    @Autowired
    private CourseController courseController;

    private Course course1, course2;

    @BeforeEach
    void setUp() {
        course1 = new Course();
        course1.setId(1);
        course1.setName("Calculus");

        course2 = new Course();
        course2.setId(2);
        course2.setName("Physics");

        Mockito.when(courseService.readByStudents_Id(1))
                .thenReturn(Arrays.asList(course1, course2));
        Mockito.when(courseService.readByCredits(5))
                .thenReturn(Arrays.asList(course1));
        Mockito.when(courseService.readByName("Calculus"))
                .thenReturn(Arrays.asList(course1));
    }

    @Test
    void readByStudents_Id_Found() {
        Collection<Course> courses = courseController.readByStudents_Id(1);
        Assertions.assertFalse(courses.isEmpty());
        Assertions.assertTrue(courses.contains(course1));
        Assertions.assertTrue(courses.contains(course2));
    }

    @Test
    void readByCredits_Found() {
        Collection<Course> courses = courseController.readByCredits(5);
        Assertions.assertFalse(courses.isEmpty());
        Assertions.assertTrue(courses.contains(course1));
    }

    @Test
    void getCourseIdByName_Found() {
        Collection<Course> courses = courseController.getCourseIdByName("Calculus");
        Assertions.assertFalse(courses.isEmpty());
        Assertions.assertTrue(courses.contains(course1));
    }
}
