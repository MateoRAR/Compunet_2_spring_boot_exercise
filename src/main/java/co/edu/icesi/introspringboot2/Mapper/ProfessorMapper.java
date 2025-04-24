package co.edu.icesi.introspringboot2.Mapper;

import co.edu.icesi.introspringboot2.DTO.ProfessorDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    @Mapping(target = "coursesIds", source = "courseList")
    ProfessorDTO toDTO(Professor professor);

    @Mapping(target = "courseList", source = "coursesIds")
    Professor toEntity(ProfessorDTO professorDTO);

    default List<Long> mapCoursesToIds(List<Course> courses) {
        if (courses == null) return null;
        return courses.stream()
                .map(Course::getId)
                .collect(Collectors.toList());
    }

    default List<Course> mapIdsToCourses(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> {
                    Course course = new Course();
                    course.setId(id);
                    return course;
                })
                .collect(Collectors.toList());
    }
}
