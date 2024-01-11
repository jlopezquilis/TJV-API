package cz.cvut.fit.tjv.project.tjvapi.controllers;

import cz.cvut.fit.tjv.project.tjvapi.entities.Course;
import cz.cvut.fit.tjv.project.tjvapi.entities.Student;
import cz.cvut.fit.tjv.project.tjvapi.repositories.StudentRepository;
import cz.cvut.fit.tjv.project.tjvapi.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController extends CrudController<Student, Integer, StudentService, StudentRepository> {
    public StudentController(StudentService service) {
        super(service);
    }

    @GetMapping("/{courseId}/getStudentsByCourseId")
    public Collection<Student> readByCourses_Id(@PathVariable int courseId) {
        Optional<Collection<Student>> optionalList = Optional.ofNullable(service.readByCourses_Id(courseId));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{studentId}/obtainTotalEnrolledCredits")
    public Integer obtainTotalEnrolledCredits(@PathVariable int studentId) {
        Optional<Integer> optionalSolution = service.obtainTotalEnrolledCredits(studentId).describeConstable();
        if (optionalSolution.isPresent()) {
            return optionalSolution.get();
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/idByName/{studentName}")
    public Collection<Student> getCourseIdByName(@PathVariable String studentName) {
        Optional<Collection<Student>> optionalList = Optional.ofNullable(service.readByName(studentName));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
