package cz.cvut.fit.tjv.project.tjvapi.repositories;

import cz.cvut.fit.tjv.project.tjvapi.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    // Complete CRUD methods are already included by extending CrudRepository.

    // Custom query methods for managing many-to-many relationship with Student
    Collection<Course> findByStudents_Id(int studentId);

    // Additional custom query methods if needed, like finding by teacher or credits
    Collection<Course> findByCredits(int credits);

    Collection<Course> findByName(String name);
}