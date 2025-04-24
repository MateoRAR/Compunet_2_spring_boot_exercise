package co.edu.icesi.introspringboot2.DTO;

import java.util.List;

public class StudentDTO {
    public long id;
    public String name;
    public String code;
    public String program;
    public List<Long> enrolledCourses;

    public StudentDTO() {
    }

    public StudentDTO(long id, String name, String code, String program, List<Long> enrolledCourses) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.program = program;
        this.enrolledCourses = enrolledCourses;
    }

    public List<Long> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Long> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
