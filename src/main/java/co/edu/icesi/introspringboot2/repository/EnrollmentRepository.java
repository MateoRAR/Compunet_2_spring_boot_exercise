package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findEnrollmentByStudent_id(Long student_id);
    List<Enrollment> findEnrollmentByCourse_id(Long course_id);
    List<Enrollment> findByStudent_id(long studentId);

    List<Enrollment> findByCourse(String name);

    List<Enrollment> findByStudent(String code);
}