package cz.cvut.fit.tjv.project.tjvapi.controllers;

import cz.cvut.fit.tjv.project.tjvapi.entities.Course;
import cz.cvut.fit.tjv.project.tjvapi.entities.Student;
import cz.cvut.fit.tjv.project.tjvapi.repositories.CourseRepository;
import cz.cvut.fit.tjv.project.tjvapi.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController extends CrudController<Course, Integer, CourseService, CourseRepository> {

    public CourseController(CourseService service) {
        super(service);
    }

    @GetMapping("/{studentId}/readByStudentsId")
    public List<Course> readByStudents_Id(@PathVariable int studentId) {
        Optional<List<Course>> optionalList = Optional.ofNullable(service.readByStudents_Id(studentId));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{teacherId}/readByTeacherId")
    public List<Course> readByTeacher_Id(@PathVariable int teacherId) {
        Optional<List<Course>> optionalList = Optional.ofNullable(service.readByTeacher_Id(teacherId));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{credits}/readByCredits")
    public List<Course> readByCredits(@PathVariable int credits) {
        Optional<List<Course>> optionalList = Optional.ofNullable(service.readByCredits(credits));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
