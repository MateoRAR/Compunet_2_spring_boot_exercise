package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;


    public StudentController(@Qualifier("studentServiceImpl") StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity< List<Student> > all() {
        var list = studentService.getAllStudents();
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestBody Student student) {
        studentService.createStudent(student);
        return "Creando un estudiante " + student.getName();
    }


}
