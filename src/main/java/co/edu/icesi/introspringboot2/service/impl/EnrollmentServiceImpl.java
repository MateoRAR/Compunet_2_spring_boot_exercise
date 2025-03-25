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
    public List<Student> findByCourse(String name) {
        Course course = courseService.findByName(name);
        List<Student> students = new java.util.ArrayList<>(List.of());
        for (Enrollment enrollment : enrollmentRepository.findByCourse(course)) {
            students.add(enrollment.getStudent());
        }
        return students;
    }

    @Override
    public List<Course> findByStudent(String code){
        Student student = studentService.findByCode(code);
        List<Course> courses = new java.util.ArrayList<>(List.of());
        for (Enrollment enrollment : enrollmentRepository.findByStudent(student)) {
            courses.add(enrollment.getCourse());
        }
        return courses;
    }
}
