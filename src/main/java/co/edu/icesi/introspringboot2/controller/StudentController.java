package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String student(Model model) {
        model.addAttribute("greeting ", "Hello, Student!");
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("student", new Student());
        return "student_tp";
    }


    @PostMapping
    public String saveStudent(Student student) {
        studentService.createStudent(student);
        return "redirect:/student";
    }
}
