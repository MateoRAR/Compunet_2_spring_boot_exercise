package co.edu.icesi.introspringboot2.DTO;

import java.util.List;

public class ProfessorDTO {
    private long id;
    private String name;
    private List<Long> coursesIds;

    public ProfessorDTO() {
    }

    public ProfessorDTO(long id, String name, List<Long> courses) {
        this.id = id;
        this.name = name;
        this.coursesIds = courses;
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

    public List<Long> getCoursesIds() {
        return coursesIds;
    }

    public void setCoursesIds(List<Long> coursesIds) {
        this.coursesIds = coursesIds;
    }
}
