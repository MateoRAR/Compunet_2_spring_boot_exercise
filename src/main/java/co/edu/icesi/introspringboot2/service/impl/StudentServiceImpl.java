package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.Mapper.StudentMapper;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public StudentDTO findById(Long id) {
        return studentMapper.toDTO(studentRepository.findById(id).orElseThrow( () -> new RuntimeException("Student not found" + id)));
    }


    @Override
    public StudentDTO findByCode(String code) {
        if (!isAvailable(code)){
            return studentMapper.toDTO(studentRepository.findByCode(code).get());
        } else {
            throw new RuntimeException("Student not found" + code);
        }
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        if (!isAvailable(studentDTO.getCode())){
            Student student = studentMapper.toEntity(studentDTO);
            return studentMapper.toDTO(studentRepository.save(student));
        } else {
            throw new RuntimeException("Student not found" + studentDTO.getCode());
        }
    }

    @Override
    public Page<StudentDTO> findAll(long id, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Student> pageStudents = studentRepository.findPageById(id, pageable);
        return pageStudents.map(studentMapper::toDTO);
    }


}
