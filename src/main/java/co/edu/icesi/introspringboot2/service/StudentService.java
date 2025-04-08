package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
    List<StudentDTO> findByProgram(String program);
    List<StudentDTO> getStudentsByProgram(String Program);

    StudentDTO findByCode(String code);
}
