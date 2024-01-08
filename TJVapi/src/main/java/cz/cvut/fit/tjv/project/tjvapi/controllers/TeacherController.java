package cz.cvut.fit.tjv.project.tjvapi.controllers;

import cz.cvut.fit.tjv.project.tjvapi.entities.Course;
import cz.cvut.fit.tjv.project.tjvapi.entities.Student;
import cz.cvut.fit.tjv.project.tjvapi.entities.Teacher;
import cz.cvut.fit.tjv.project.tjvapi.repositories.TeacherRepository;
import cz.cvut.fit.tjv.project.tjvapi.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController extends CrudController<Teacher, Integer, TeacherService, TeacherRepository> {

    public TeacherController(TeacherService service) {
        super(service);
    }

    @GetMapping("/{department}/readByDepartment")
    public Collection<Teacher> readByDepartment(@PathVariable String department) {
        Optional<Collection<Teacher>> optionalList = Optional.ofNullable(service.readByDepartment(department));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{teacherId}/obtainStudentsTaughtByTeacher")
    public Collection<Student> obtainStudentsTaughtByTeacher(@PathVariable Integer teacherId) {
        Optional<Collection<Student>> optionalList = Optional.ofNullable(service.obtainStudentsTaughtByTeacher(teacherId));
        if (optionalList.isPresent())
            return optionalList.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
