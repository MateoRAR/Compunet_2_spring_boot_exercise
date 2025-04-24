package co.edu.icesi.introspringboot2.Mapper;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
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


    default List<Long> mapEnrollmentsToIds(List<Enrollment> enrollments) {
        if (enrollments == null) return null;
        return enrollments.stream()
                .map(Enrollment::getId)
                .collect(Collectors.toList());
    }

    default List<Enrollment> mapIdsToEnrollments(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> {
                    Enrollment e = new Enrollment();
                    e.setId(id);
                    return e;
                }).collect(Collectors.toList());
    }

}