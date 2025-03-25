package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    List<Student> findByProgram(String program);
    List<Student> getStudentsByProgram(String Program);

    Student findByCode(String code);
}
