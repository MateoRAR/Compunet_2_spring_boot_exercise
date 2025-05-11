package co.edu.icesi.introspringboot2.service;



import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.DTO.EnrollmentDTO;
import co.edu.icesi.introspringboot2.DTO.StudentDTO;

import java.util.List;

public interface EnrollmentService {
     EnrollmentDTO enroll(long studentId, long courseId);
     List<EnrollmentDTO> getAllEnrollments();
     List<EnrollmentDTO> findByCourseId(long courseId);
     List<EnrollmentDTO> findByStudentId(long studentId);
     EnrollmentDTO deleteEnrollment(long id);
}
