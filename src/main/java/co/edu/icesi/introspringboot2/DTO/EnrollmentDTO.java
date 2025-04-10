package co.edu.icesi.introspringboot2.DTO;

public class EnrollmentDTO {
    private long id;
    private long studentId;
    private long courseId;

    public EnrollmentDTO(){

    }

    public EnrollmentDTO(long id, long student, long course) {
        this.id = id;
        this.studentId = student;
        this.courseId = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
}
