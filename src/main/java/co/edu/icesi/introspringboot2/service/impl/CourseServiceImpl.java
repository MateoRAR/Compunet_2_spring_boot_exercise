package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;
import co.edu.icesi.introspringboot2.DTO.EnrollmentDTO;
import co.edu.icesi.introspringboot2.DTO.ProfessorDTO;
import co.edu.icesi.introspringboot2.Mapper.CourseMapper;
import co.edu.icesi.introspringboot2.Mapper.EnrollmentMapper;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Professor;
import co.edu.icesi.introspringboot2.repository.CourseRepository;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        if (isAvailable(courseDTO.getName())) {
            Course course = courseMapper.toEntity(courseDTO);
            return courseMapper.toDTO(courseRepository.save(course));
        } else {
            throw new RuntimeException("course already exists");
        }
    }

    public boolean isAvailable(String name) {
        return courseRepository.findByName(name).isEmpty();
    }


    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(long id) {
        Optional<Course> optCourse = courseRepository.findById(id);
        if(optCourse.isPresent()){
            return courseMapper.toDTO(optCourse.get());
        } else {
            throw new RuntimeException("Course not found" + id);
        }

        // return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found" + id));
    }

    @Override
    public List<CourseDTO> findByProfessorId(Long id) {

        ProfessorDTO professorDTO = professorService.findById(id);

        return courseRepository.findByProfessorId(professorDTO.getId()).stream().map(courseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<CourseDTO> searchCoursesByName(String name, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return courseRepository.findByNameContainingIgnoreCase(name, pageable).map(courseMapper::toDTO);
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
    public CourseDTO findByName(String name) {
        if (!isAvailable(name)){
            return courseMapper.toDTO(courseRepository.findByName(name).get());
        } else {
            throw new RuntimeException("Course not found" + name);
        }
    }

}
