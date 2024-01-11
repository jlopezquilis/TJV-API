package cz.cvut.fit.tjv.project.tjvapi.repositories;

import cz.cvut.fit.tjv.project.tjvapi.entities.Student;
import cz.cvut.fit.tjv.project.tjvapi.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    Collection<Teacher> findByDepartment(String department);

    Collection<Teacher> findByName(String name);

    @Query("SELECT DISTINCT s FROM Teacher t JOIN t.courses c JOIN c.students s WHERE t.id = :teacherId")
    Collection<Student> getStudentsTaughtByTeacher(@Param("teacherId") int teacherId);
}