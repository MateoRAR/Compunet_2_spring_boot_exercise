package co.edu.icesi.introspringboot2.DTO;

public class EnrollmentDTO {
    private String id;
    private StudentDTO student;
    private CourseDTO course;

    public EnrollmentDTO(){

    }

    public EnrollmentDTO(String id, StudentDTO student, CourseDTO course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }
}
