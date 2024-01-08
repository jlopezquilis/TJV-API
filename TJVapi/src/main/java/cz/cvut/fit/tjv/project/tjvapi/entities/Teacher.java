package cz.cvut.fit.tjv.project.tjvapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Teacher implements EntityWithId<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    @SequenceGenerator(name="teacher_seq", sequenceName = "teacher_seq", allocationSize=1)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String department;

    @JsonBackReference
    @OneToMany(mappedBy = "teacher")
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }

}
