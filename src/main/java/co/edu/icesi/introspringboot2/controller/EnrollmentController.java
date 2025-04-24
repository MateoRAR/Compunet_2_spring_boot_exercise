package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.DTO.EnrollmentDTO;
import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> getAllCourses() {
        return ResponseEntity.status(200).body(enrollmentService.getAllEnrollments());
    }
}