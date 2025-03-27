package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.repository.CourseRepository;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {



    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProfessorService professorService;

    @Override
    public Course createCourse(Course course) {
        if (isAvailable(course.getName())) {
            return courseRepository.save(course);
        } else {
            throw new RuntimeException("course already exists");
        }
    }

    public boolean isAvailable(String name) {
        return courseRepository.findByName(name).isEmpty();
    }

    @Override
    public List<Course> getCoursesByStudent_id(long student_id) {
        //List<Enrollment> enrollments = enrollmentRepository.findByStudent_id(student_id);
        return null; //enrollments.stream().map(Enrollment::getCourse).toList();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(long id) {
        Optional<Course> optCourse = courseRepository.findById(id);
        if(optCourse.isPresent()){
            return optCourse.get();
        } else {
            throw new RuntimeException("Course not found" + id);
        }

        // return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found" + id));
    }

    @Override
    public List<Course> findByProfessorId(Long id) {
        return courseRepository.findByProfessor(professorService.findById(id));
    }

    @Override
    public void deleteCourse(long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found" + courseId);
        } else {
            courseRepository.deleteById(courseId);
        }
    }

    @Override
    public void deleteAll() {
        courseRepository.deleteAll();
    }

    @Override
    public Course findByName(String name) {
        if (!isAvailable(name)){
            return courseRepository.findByName(name).get();
        } else {
            throw new RuntimeException("Course not found" + name);
        }
    }

}
