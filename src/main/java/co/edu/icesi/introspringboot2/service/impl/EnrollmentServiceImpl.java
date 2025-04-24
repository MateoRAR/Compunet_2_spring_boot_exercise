package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.DTO.EnrollmentDTO;
import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.Mapper.EnrollmentMapper;
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


    @Override
    @Transactional
    public void enroll(String code, String name) {
        StudentDTO student = studentService.findByCode(code);
        CourseDTO course = courseService.findByName(name);
        EnrollmentDTO enrollment = new EnrollmentDTO(1,student.getId(), course.getId());
        enrollmentRepository.save(enrollmentMapper.toEntity(enrollment));
    }

    @Override
    public List<EnrollmentDTO> findByCourse(String name) {
        CourseDTO course = courseService.findByName(name);
        return enrollmentRepository.findByCourseName(course.getName()).stream().map(enrollment -> enrollmentMapper.toDTO(enrollment)).collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDTO> findByStudent(String code){
        StudentDTO student = studentService.findByCode(code);
        return enrollmentRepository.findByStudentCode(student.getCode()).stream().map(enrollment -> enrollmentMapper.toDTO(enrollment)).collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll().stream().map(enrollment ->
                enrollmentMapper.toDTO(enrollment)).collect(Collectors.toList());
    }


}
