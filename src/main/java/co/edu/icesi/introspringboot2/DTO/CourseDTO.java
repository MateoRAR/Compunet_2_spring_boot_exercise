package co.edu.icesi.introspringboot2.DTO;

import java.util.List;

public class CourseDTO {
    private long id;
    private String name;
    private long professorId;
    private List<Long> enrollmentIds;

    public CourseDTO() {
    }

    public CourseDTO(long id, String name, Long professorId, List<Long> enrollmentIds) {
        this.id = id;
        this.name = name;
        this.professorId = professorId;
        this.enrollmentIds = enrollmentIds;
    }

    public List<Long> getEnrollmentIds() {
        return enrollmentIds;
    }

    public void setEnrollmentIds(List<Long> enrollmentIds) {
        this.enrollmentIds = enrollmentIds;
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

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }
}