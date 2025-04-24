package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllCourses() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }
}