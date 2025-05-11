package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.DTO.EnrollmentDTO;
import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.Mapper.CourseMapper;
import co.edu.icesi.introspringboot2.Mapper.EnrollmentMapper;
import co.edu.icesi.introspringboot2.Mapper.StudentMapper;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {


    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentMapper studentMapper;


    @Override
    @Transactional
    public EnrollmentDTO enroll(long studentId, long courseId) {

        StudentDTO student = studentService.findById(studentId);
        CourseDTO course = courseService.findById(courseId);

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(studentMapper.toEntity(student));
        enrollment.setCourse(courseMapper.toEntity(course));
        return enrollmentMapper.toDTO(enrollmentRepository.save(enrollment));
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll().stream().map(enrollment ->
                enrollmentMapper.toDTO(enrollment)).collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDTO> findByCourseId(long courseId) {
        return enrollmentRepository.findByCourseId(courseId).stream().map(
                enrollment -> enrollmentMapper.toDTO(enrollment)).collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDTO> findByStudentId(long studentId) {
        return enrollmentRepository.findByStudentId(studentId).stream().map(
                enrollment -> enrollmentMapper.toDTO(enrollment)).collect(Collectors.toList());
    }

    @Override
    public EnrollmentDTO deleteEnrollment(long id) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Enrollment not found" + id));
        enrollmentRepository.delete(enrollment);
        return enrollmentMapper.toDTO(enrollment);
    }


}
