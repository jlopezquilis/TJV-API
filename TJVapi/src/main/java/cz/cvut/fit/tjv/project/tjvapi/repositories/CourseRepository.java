package cz.cvut.fit.tjv.project.tjvapi.repositories;

import cz.cvut.fit.tjv.project.tjvapi.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    // Complete CRUD methods are already included by extending CrudRepository.

    // Custom query methods for managing many-to-many relationship with Student
    List<Course> findByStudents_Id(int studentId);

    // Additional custom query methods if needed, like finding by teacher or credits
    List<Course> findByCredits(int credits);
}