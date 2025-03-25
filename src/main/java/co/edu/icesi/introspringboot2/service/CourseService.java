package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course createCourse(Course course);

    List<Course> getCoursesByStudent_id(long student_id);

    List<Course> getAllCourses();

    Course getCourseById(long l);

    void deleteCourse(long courseId);

    void deleteAll();

    Course findByName(String name);
}
