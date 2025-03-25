package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {


    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Override
    @Transactional
    public void enroll(String code, String name) {
        Student student = studentService.findByCode(code);
        Course course = courseService.findByName(name);
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Student> getStudentsByCourse(String name){
        Course course = courseService.findByName(name);
        return enrollmentRepository.getStudentsByCourse(course);
    }

    @Override
    public List<Course> getCoursesByStudent(String code){
        Student student = studentService.findByCode(code);
        return enrollmentRepository.getCoursesByStudent(student);
    }
}
