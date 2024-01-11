package cz.cvut.fit.tjv.project.tjvapi.repositories;

import cz.cvut.fit.tjv.project.tjvapi.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/*
* Repositories are interfaces that directly interact with the data layer of your application.
* They are part of the Data Access Object (DAO) pattern and are responsible for encapsulating the logic
* required to access data sources. .
* */

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    // Custom query methods for managing many-to-many relationship with Course
    Collection<Student> findByCourses_Id(int courseId);

    Collection<Student> findByName(String name);

    @Query("SELECT SUM(c.credits) FROM Student s JOIN s.courses c WHERE s.id = :studentId")
    Integer getTotalEnrolledCredits(@Param("studentId") int studentId);
}