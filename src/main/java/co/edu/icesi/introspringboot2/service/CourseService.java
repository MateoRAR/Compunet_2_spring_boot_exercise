package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course createCourse(Course course);

    List<Course> getCoursesByStudent_id(long student_id);

    List<Course> getAllCourses();

    void deleteCourse(long courseId);

    void deleteAll();

    Course findByName(String name);

    Course findById(long id);

    List<Course> findByProfessorId(Long id);
}
