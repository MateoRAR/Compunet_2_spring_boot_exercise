package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.DTO.CourseDTO;


import java.util.List;
import java.util.Optional;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);

    List<CourseDTO> getCoursesByStudent_id(long student_id);

    List<CourseDTO> getAllCourses();

    void deleteCourse(long courseId);

    void deleteAll();

    CourseDTO findByName(String name);

    CourseDTO findById(long id);

    List<CourseDTO> findByProfessorId(Long id);
}
