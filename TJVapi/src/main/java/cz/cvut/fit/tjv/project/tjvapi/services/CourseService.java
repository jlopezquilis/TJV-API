package cz.cvut.fit.tjv.project.tjvapi.services;

import cz.cvut.fit.tjv.project.tjvapi.entities.Course;
import cz.cvut.fit.tjv.project.tjvapi.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CourseService extends CrudService<Course, Integer, CourseRepository>{
    public CourseService(CourseRepository repository) {
        super(repository);
    }

    public Collection<Course> readByStudents_Id(int studentId) {
        return repository.findByStudents_Id(studentId);
    }
    public Collection<Course> readByCredits(int credits) {
        return repository.findByCredits(credits);
    }
    public Collection<Course> readByName(String name) {return repository.findByName(name);}
}
