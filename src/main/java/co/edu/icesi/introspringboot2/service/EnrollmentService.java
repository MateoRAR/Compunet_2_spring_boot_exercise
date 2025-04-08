package co.edu.icesi.introspringboot2.service;



import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.DTO.StudentDTO;

import java.util.List;

public interface EnrollmentService {
     void enroll(String code, String name);
     List<StudentDTO> findByCourse(String name);
     List<CourseDTO> findByStudent(String code);
}
