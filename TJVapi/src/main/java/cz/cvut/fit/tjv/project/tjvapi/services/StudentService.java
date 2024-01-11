package cz.cvut.fit.tjv.project.tjvapi.services;

import cz.cvut.fit.tjv.project.tjvapi.entities.Course;
import cz.cvut.fit.tjv.project.tjvapi.entities.Student;
import cz.cvut.fit.tjv.project.tjvapi.repositories.StudentRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collection;

/*
* While repositories are about data access, services deal with business logic.
* The service layer sits between the presentation layer (controllers) and the data access layer (repositories).
* It contains business logic, calls methods defined in repositories to interact with the database,
* and performs higher-level data operations and transformations.
* */

@Service
public class StudentService extends CrudService<Student, Integer, StudentRepository>{

    public StudentService(StudentRepository repository) {
        super(repository);
    }

    public Collection<Student> readByCourses_Id(int courseId) {
        return repository.findByCourses_Id(courseId);
    }
    public Integer obtainTotalEnrolledCredits(int studentId) {
        return repository.getTotalEnrolledCredits(studentId);
    }
    public Collection<Student> readByName(String name) {return repository.findByName(name);}
}
