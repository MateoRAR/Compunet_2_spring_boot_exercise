package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.DTO.EnrollmentDTO;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Value("${app.pagination.size}")
    private int pageSize;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }


    @GetMapping("/student")
    public ResponseEntity<List<CourseDTO>> getAllCoursesByStudent(@RequestParam long id){
        List<Long> enrollments = enrollmentService.findByStudentId(id).stream()
                .map(EnrollmentDTO::getCourseId).toList();

        List<CourseDTO> courses = enrollments.stream().map(enrollment -> courseService.findById(enrollment)).toList();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity.status(201).body(courseService.createCourse(courseDTO));
    }

    @GetMapping("/quantity")
    public ResponseEntity<?> getCoursesQuantity() {
        List<CourseDTO> courses = courseService.getAllCourses();

        ArrayList<Object> coursesWithQuantity = new ArrayList<>();

        for (CourseDTO course : courses) {
            long quantity = course.getEnrollmentIds().size();
            coursesWithQuantity.add(Map.of("course", course, "quantity", quantity));
        }

        return ResponseEntity.status(200).body(coursesWithQuantity);
    }

    @GetMapping("/search")
    public Page<CourseDTO> searchCoursesByName(@RequestParam String name, @RequestParam(defaultValue = "0") int page, @RequestParam(required = false) Integer size, @RequestParam(defaultValue = "id") String sortBy) {
        int effectiveSize = (size != null) ? size : pageSize;
        return courseService.searchCoursesByName(name, page, effectiveSize, sortBy);
    }
}
