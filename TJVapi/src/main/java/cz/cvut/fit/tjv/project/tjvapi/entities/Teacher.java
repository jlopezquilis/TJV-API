package cz.cvut.fit.tjv.project.tjvapi.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

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

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer integer) {
        id = integer;
    }

    // Constructors, getters, setters, and methods
}
