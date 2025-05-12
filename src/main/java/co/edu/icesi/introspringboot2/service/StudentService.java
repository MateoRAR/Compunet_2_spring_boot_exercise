package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
    List<StudentDTO> findByProgram(String program);
    StudentDTO findById(Long id);
    StudentDTO findByCode(String code);
    StudentDTO updateStudent(StudentDTO studentDTO);
    public Page<StudentDTO> findAll(int page, int size, String sortBy);
}
