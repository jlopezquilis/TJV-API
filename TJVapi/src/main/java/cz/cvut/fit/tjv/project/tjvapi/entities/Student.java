package cz.cvut.fit.tjv.project.tjvapi.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Student implements EntityWithId<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name="student_seq", sequenceName = "student_seq", allocationSize=1)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @ManyToMany(mappedBy = "students")
    private Collection<Course> courses;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer integer) {
        id = integer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }
}
