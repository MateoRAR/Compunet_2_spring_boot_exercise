package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;

import java.util.List;

public interface EnrollmentService {
     void enroll(String code, String name);
     List<Student> getStudentsByCourse(String name);
     List<Course> getCoursesByStudent(String code);
}
