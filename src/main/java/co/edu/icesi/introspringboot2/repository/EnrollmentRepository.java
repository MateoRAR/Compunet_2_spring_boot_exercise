package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudentId(long studentId);
    List<Enrollment> findByCourseId(long courseId);

    List<Enrollment> findByCourseName(String name);

    List<Enrollment> findByStudentCode(String code);
}