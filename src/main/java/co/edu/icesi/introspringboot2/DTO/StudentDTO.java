package co.edu.icesi.introspringboot2.DTO;

public class StudentDTO {
    public long id;
    public String name;
    public String code;
    public String program;

    public StudentDTO() {
    }

    public StudentDTO(long id, String name, String code, String program) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.program = program;
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
