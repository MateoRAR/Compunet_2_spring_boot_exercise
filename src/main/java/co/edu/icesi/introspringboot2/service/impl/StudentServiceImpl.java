package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
