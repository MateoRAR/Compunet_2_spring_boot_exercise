package co.edu.icesi.introspringboot2.Mapper;

import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.util.EnrollmentMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = EnrollmentMapperHelper.class)
public interface StudentMapper {

    @Mapping(source="enrollments", target = "enrollmentsIds")
    StudentDTO toDTO(Student student);

    @Mapping(source="enrollmentsIds", target = "enrollments")
    Student toEntity(StudentDTO dto);

}
