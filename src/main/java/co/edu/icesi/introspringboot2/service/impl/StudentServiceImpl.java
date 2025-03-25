package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        if (isAvailable(student.getCode())){
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student already exists");
        }
    }

    public boolean isAvailable(String code) {
        return studentRepository.findByCode(code).isEmpty();
    }



    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByProgram(String program) {
        return studentRepository.findByProgram(program);
    }

    @Override
    public List<Student> getStudentsByProgram(String Program) {
        return List.of();
    }

    @Override
    public Student findByCode(String code) {
        if (!isAvailable(code)){
            return studentRepository.findByCode(code).get();
        } else {
            throw new RuntimeException("Student not found" + code);
        }
    }


}
