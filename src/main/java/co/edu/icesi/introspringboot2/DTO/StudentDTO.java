package co.edu.icesi.introspringboot2.DTO;

import java.util.List;

public class StudentDTO {
    public long id;
    public String name;
    public String code;
    public String program;
    public List<Long> enrollmentsIds;

    public StudentDTO() {
    }

    public StudentDTO(long id, String name, String code, String program, List<Long> enrollmentsIds) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.program = program;
        this.enrollmentsIds = enrollmentsIds;
    }

    public List<Long> getEnrollmentsIds() {
        return enrollmentsIds;
    }

    public void setEnrollmentsIds(List<Long> enrolledCourses) {
        this.enrollmentsIds = enrolledCourses;
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
