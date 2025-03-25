package co.edu.icesi.introspringboot2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professors_seq")
    @SequenceGenerator(name = "professors_seq", sequenceName = "professors_id_seq", allocationSize = 1)
    private long id;

    private String name;

    @OneToMany(mappedBy = "professor")
    @JsonIgnore
    private List<Course> courseList;

    public Professor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
