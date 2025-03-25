package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.entity.Professor;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private CourseService courseService;

    // Listado de todos los profesores
    @GetMapping
    public String listProfessors(Model model) {
        model.addAttribute("professors", professorService.getAllProfessors());
        return "professor_list";
    }

    // Detalles de un profesor específico
    @GetMapping("/details/{id}")
    public String professorDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("professor", professorService.findById(id));
        model.addAttribute("professorCourses", courseService.findByProfessorId(id));
        return "professor_detail";
    }
}
