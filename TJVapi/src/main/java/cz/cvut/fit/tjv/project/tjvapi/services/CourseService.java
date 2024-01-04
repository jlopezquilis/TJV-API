package cz.cvut.fit.tjv.project.tjvapi.services;

import cz.cvut.fit.tjv.project.tjvapi.entities.Course;
import cz.cvut.fit.tjv.project.tjvapi.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService extends CrudService<Course, Integer, CourseRepository>{
    public CourseService(CourseRepository repository) {
        super(repository);
    }

    public List<Course> readByStudents_Id(int studentId) {
        return repository.findByStudents_Id(studentId);
    }
    public List<Course> readByTeacher_Id(int teacherId) {
        return repository.findByTeacher_Id(teacherId);
    }
    public List<Course> readByCredits(int credits) {
        return repository.findByCredits(credits);
    }
}
