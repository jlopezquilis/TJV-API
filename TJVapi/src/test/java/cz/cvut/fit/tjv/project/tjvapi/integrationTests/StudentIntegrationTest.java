package cz.cvut.fit.tjv.project.tjvapi.integrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//Integration Test: Controller - HTTP responses
/*
AIM: testing the controller in conjunction with other layers of the Spring application,
such as the service layer and repository layer
 */

@SpringBootTest
//This annotation is used in conjunction with @SpringBootTest to add autoconfiguration for MockMvc.
@AutoConfigureMockMvc
@Transactional
public class StudentIntegrationTest {

    /*
    MockMvc provides a powerful way to test HTTP requests and responses in Spring MVC.
    It allows you to send HTTP requests to the DispatcherServlet (the central servlet in
    Spring MVC that dispatches requests to handlers) and assert or verify the responses.
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReadByCourses_Id() throws Exception {
        int courseId = 1; // Replace with a valid courseId
        mockMvc.perform(get("/student/" + courseId + "/getStudentsByCourseId"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$[*].courseId", everyItem(is(courseId))));
    }

    @Test
    public void testReadByCourses_Id_NotFound() throws Exception {
        int invalidCourseId = -1;
        mockMvc.perform(get("/student/" + invalidCourseId + "/getStudentsByCourseId"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    public void testObtainTotalEnrolledCredits() throws Exception {
        int studentId = 1; // Replace with a valid studentId
        mockMvc.perform(get("/student/" + studentId + "/obtainTotalEnrolledCredits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", isA(Integer.class)));
    }

    @Test
    public void testGetCourseIdByName() throws Exception {
        String studentName = "Bob Brown";
        mockMvc.perform(get("/student/idByName/" + studentName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$[*].name", everyItem(is(studentName))));
    }

    // Additional test cases can be added here as needed
}