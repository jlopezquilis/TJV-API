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

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController extends CrudController<Course, Integer, CourseService, CourseRepository> {

    public CourseController(CourseService service) {
        super(service);
    }

    @GetMapping("/{studentId}/readByStudentsId")
    public Collection<Course> readByStudents_Id(@PathVariable int studentId) {
        Optional<Collection<Course>> optionalList = Optional.ofNullable(service.readByStudents_Id(studentId));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{credits}/readByCredits")
    public Collection<Course> readByCredits(@PathVariable int credits) {
        Optional<Collection<Course>> optionalList = Optional.ofNullable(service.readByCredits(credits));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/idByName/{courseName}")
    public Collection<Course> getCourseIdByName(@PathVariable String courseName) {
        Optional<Collection<Course>> optionalList = Optional.ofNullable(service.readByName(courseName));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
