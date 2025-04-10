package co.edu.icesi.introspringboot2.Mapper;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Professor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-10T14:56:12-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDTO toDTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setProfessorId( courseProfessorId( course ) );
        courseDTO.setId( course.getId() );
        courseDTO.setName( course.getName() );

        return courseDTO;
    }

    @Override
    public Course toEntity(CourseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Course course = new Course();

        course.setProfessor( courseDTOToProfessor( dto ) );
        course.setId( dto.getId() );
        course.setName( dto.getName() );

        return course;
    }

    @Override
    public void updateEntityFromDTO(CourseDTO dto, Course course) {
        if ( dto == null ) {
            return;
        }

        if ( course.getProfessor() == null ) {
            course.setProfessor( new Professor() );
        }
        courseDTOToProfessor1( dto, course.getProfessor() );
        course.setId( dto.getId() );
        course.setName( dto.getName() );
    }

    private Long courseProfessorId(Course course) {
        if ( course == null ) {
            return null;
        }
        Professor professor = course.getProfessor();
        if ( professor == null ) {
            return null;
        }
        long id = professor.getId();
        return id;
    }

    protected Professor courseDTOToProfessor(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        if ( courseDTO.getProfessorId() != null ) {
            professor.setId( courseDTO.getProfessorId() );
        }

        return professor;
    }

    protected void courseDTOToProfessor1(CourseDTO courseDTO, Professor mappingTarget) {
        if ( courseDTO == null ) {
            return;
        }

        if ( courseDTO.getProfessorId() != null ) {
            mappingTarget.setId( courseDTO.getProfessorId() );
        }
    }
}
