package co.edu.icesi.introspringboot2.Mapper;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.util.EnrollmentMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = EnrollmentMapperHelper.class)
public interface CourseMapper {

    @Mapping(source = "enrollments", target = "enrollmentIds")
    @Mapping(source = "professor.id", target = "professorId")
    CourseDTO toDTO(Course course);

    @Mapping(source = "enrollmentIds", target = "enrollments")
    @Mapping(source = "professorId", target = "professor.id")
    Course toEntity(CourseDTO dto);

    @Mapping(source = "enrollmentIds", target = "enrollments")
    @Mapping(source = "professorId", target = "professor.id")
    void updateEntityFromDTO(CourseDTO dto, @MappingTarget Course course);

}