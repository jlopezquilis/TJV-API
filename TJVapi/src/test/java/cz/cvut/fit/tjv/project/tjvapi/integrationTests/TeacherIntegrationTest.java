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
public class TeacherIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReadByDepartment() throws Exception {
        String department = "Mathematics"; // Replace with an existing department
        mockMvc.perform(get("/teacher/" + department + "/readByDepartment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())));
    }

    @Test
    public void testObtainStudentsTaughtByTeacher() throws Exception {
        Integer teacherId = 1; // Replace with a valid teacherId
        mockMvc.perform(get("/teacher/" + teacherId + "/obtainStudentsTaughtByTeacher"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())));
    }

    @Test
    public void testGetTeacherIdByName() throws Exception {
        String teacherName = "John Smith"; // Replace with a valid teacher name
        mockMvc.perform(get("/teacher/idByName/" + teacherName))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())));
    }

    @Test
    public void testReadCoursesByTeacherId() throws Exception {
        int teacherId = 1; // Replace with a valid teacherId
        mockMvc.perform(get("/teacher/getCourses/" + teacherId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())));
    }

    @Test
    public void testReadByDepartment_NotFound() throws Exception {
        String invalidDepartment = "NonExistentDepartment";
        mockMvc.perform(get("/teacher/" + invalidDepartment + "/readByDepartment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    public void testObtainStudentsTaughtByTeacher_NotFound() throws Exception {
        Integer invalidTeacherId = -1; // Use an invalid teacherId
        mockMvc.perform(get("/teacher/" + invalidTeacherId + "/obtainStudentsTaughtByTeacher"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    public void testGetTeacherIdByName_NotFound() throws Exception {
        String invalidTeacherName = "NonExistentTeacher";
        mockMvc.perform(get("/teacher/idByName/" + invalidTeacherName))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    public void testReadCoursesByTeacherId_NotFound() throws Exception {
        int invalidTeacherId = -1; // Use an invalid teacherId
        mockMvc.perform(get("/teacher/getCourses/" + invalidTeacherId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(empty())));
    }
}
