package co.edu.icesi.introspringboot2.Mapper;

import co.edu.icesi.introspringboot2.DTO.EnrollmentDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-22T15:07:53-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class EnrollmentMapperImpl implements EnrollmentMapper {

    @Override
    public Enrollment toEntity(EnrollmentDTO enrollmentDTO) {
        if ( enrollmentDTO == null ) {
            return null;
        }

        Enrollment enrollment = new Enrollment();

        enrollment.setStudent( enrollmentDTOToStudent( enrollmentDTO ) );
        enrollment.setCourse( enrollmentDTOToCourse( enrollmentDTO ) );
        if ( enrollmentDTO.getId() != null ) {
            enrollment.setId( Long.parseLong( enrollmentDTO.getId() ) );
        }

        return enrollment;
    }

    @Override
    public EnrollmentDTO toDTO(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }

        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();

        enrollmentDTO.setStudentId( enrollmentStudentId( enrollment ) );
        enrollmentDTO.setCourseId( enrollmentCourseId( enrollment ) );
        enrollmentDTO.setId( String.valueOf( enrollment.getId() ) );

        return enrollmentDTO;
    }

    protected Student enrollmentDTOToStudent(EnrollmentDTO enrollmentDTO) {
        if ( enrollmentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( enrollmentDTO.getStudentId() );

        return student;
    }

    protected Course enrollmentDTOToCourse(EnrollmentDTO enrollmentDTO) {
        if ( enrollmentDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( enrollmentDTO.getCourseId() );

        return course;
    }

    private long enrollmentStudentId(Enrollment enrollment) {
        if ( enrollment == null ) {
            return 0L;
        }
        Student student = enrollment.getStudent();
        if ( student == null ) {
            return 0L;
        }
        long id = student.getId();
        return id;
    }

    private long enrollmentCourseId(Enrollment enrollment) {
        if ( enrollment == null ) {
            return 0L;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return 0L;
        }
        long id = course.getId();
        return id;
    }
}
