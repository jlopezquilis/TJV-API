package cz.cvut.fit.tjv.project.tjvapi.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CourseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReadByStudentsId() throws Exception {
        int studentId = 1; // Replace with a valid studentId
        mockMvc.perform(get("/course/" + studentId + "/readByStudentsId"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())));
    }

    @Test
    public void testReadByStudentsId_NotFound() throws Exception {
        int invalidStudentId = -1; // Use an invalid studentId
        mockMvc.perform(get("/course/" + invalidStudentId + "/readByStudentsId"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    public void testReadByCredits() throws Exception {
        int credits = 3; // Replace with a valid credits value
        mockMvc.perform(get("/course/" + credits + "/readByCredits"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())));
    }

    @Test
    public void testReadByCredits_NotFound() throws Exception {
        int invalidCredits = -1; // Use an invalid credits value
        mockMvc.perform(get("/course/" + invalidCredits + "/readByCredits"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    public void testGetCourseIdByName() throws Exception {
        String courseName = "Business Management"; // Replace with a valid course name
        mockMvc.perform(get("/course/idByName/" + courseName))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())));
    }

    @Test
    public void testGetCourseIdByName_NotFound() throws Exception {
        String invalidCourseName = "NonExistentCourse";
        mockMvc.perform(get("/course/idByName/" + invalidCourseName))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(empty())));
    }

}
