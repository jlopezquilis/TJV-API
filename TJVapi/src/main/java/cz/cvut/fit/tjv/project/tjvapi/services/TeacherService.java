package cz.cvut.fit.tjv.project.tjvapi.services;

import cz.cvut.fit.tjv.project.tjvapi.entities.Student;
import cz.cvut.fit.tjv.project.tjvapi.entities.Teacher;
import cz.cvut.fit.tjv.project.tjvapi.repositories.TeacherRepository;

import java.util.List;

public class TeacherService extends CrudService<Teacher, Integer, TeacherRepository>{

    public TeacherService(TeacherRepository repository) {
        super(repository);
    }

    public List<Teacher> readByDepartment(String department) {
        return repository.findByDepartment(department);
    }
    public List<Student> obtainStudentsTaughtByTeacher(int teacherId) {
        return repository.getStudentsTaughtByTeacher(teacherId);
    }
}
