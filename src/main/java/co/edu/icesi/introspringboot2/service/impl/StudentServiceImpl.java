package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.Mapper.StudentMapper;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDTO createStudent(StudentDTO student) {
        if (isAvailable(student.getCode())){
            Student student_e = studentMapper.toEntity(student);
            return studentMapper.toDTO(studentRepository.save(student_e));
        } else {
            throw new RuntimeException("Student already exists");
        }
    }

    public boolean isAvailable(String code) {
        return studentRepository.findByCode(code).isEmpty();
    }



    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findByProgram(String program) {
        return studentRepository.findByProgram(program).stream().map(studentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsByProgram(String Program) {
        return List.of();
    }

    @Override
    public StudentDTO findByCode(String code) {
        if (!isAvailable(code)){
            return studentMapper.toDTO(studentRepository.findByCode(code).get());
        } else {
            throw new RuntimeException("Student not found" + code);
        }
    }


}
