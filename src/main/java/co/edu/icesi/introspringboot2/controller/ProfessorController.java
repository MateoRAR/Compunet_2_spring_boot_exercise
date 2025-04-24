package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.DTO.ProfessorDTO;
import co.edu.icesi.introspringboot2.DTO.StudentDTO;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> getAllCourses() {
        return ResponseEntity.status(200).body(professorService.getAllProfessors());
    }
}