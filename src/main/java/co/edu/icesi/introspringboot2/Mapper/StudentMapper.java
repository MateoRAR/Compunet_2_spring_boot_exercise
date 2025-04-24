package co.edu.icesi.introspringboot2.Mapper;

import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source="enrollments", target = "enrolledCourses")
    StudentDTO toDTO(Student student);

    @Mapping(source="enrolledCourses", target = "enrollments")
    Student toEntity(StudentDTO dto);

    default List<Long> mapEnrollmentsToCourseIds(List<Enrollment> enrollments) {
        if (enrollments == null) return null;
        return enrollments.stream()
                .map(e -> e.getCourse().getId())
                .collect(Collectors.toList());
    }

    default List<Enrollment> mapCourseIdsToEnrollments(List<Long> courseIds) {
        if (courseIds == null) return null;
        return courseIds.stream()
                .map(id -> {
                    Course c = new Course();
                    c.setId(id);
                    Enrollment e = new Enrollment();
                    e.setCourse(c);
                    return e;
                }).collect(Collectors.toList());
    }
}
