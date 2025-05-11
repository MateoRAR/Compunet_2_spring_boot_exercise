package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.DTO.EnrollmentDTO;
import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Value("${app.pagination.size}")
    private int pageSize;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllCourses() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @GetMapping("/course")
    public ResponseEntity<List<StudentDTO>> getAllStudentsByCourse(@RequestParam long id){
        List<Long> enrollments = enrollmentService.findByCourseId(id).stream()
                .map(EnrollmentDTO::getStudentId).toList();

        List<StudentDTO> students = enrollments.stream().map(enrollment -> studentService.findById(enrollment)).toList();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(201).body(studentService.createStudent(studentDTO));
    }

    @PatchMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(200).body(studentService.updateStudent(studentDTO));
    }

    @GetMapping("/program")
    public ResponseEntity<List<StudentDTO>> getAllStudentsByProgram(@RequestParam String program){
        List<StudentDTO> students = studentService.findByProgram(program);
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/ordered")
    public Page<StudentDTO> getStudentsByProgram(@RequestParam long id, @RequestParam(defaultValue = "0") int page, @RequestParam(required = false) Integer size, @RequestParam(defaultValue = "id") String sortBy) {
        int effectiveSize = (size != null) ? size : pageSize;
        return studentService.findAll(id, page, effectiveSize, sortBy);
    }


}