package co.edu.icesi.introspringboot2.DTO;

import java.util.List;

public class ProfessorDTO {
    private String id;
    private String name;
    private List<CourseDTO> courses;

    public ProfessorDTO() {
    }

    public ProfessorDTO(String id, String name, List<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
