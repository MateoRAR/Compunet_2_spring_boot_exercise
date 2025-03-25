package co.edu.icesi.introspringboot2.integration;

/*

import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Professor;
import co.edu.icesi.introspringboot2.repository.CourseRepository;
import co.edu.icesi.introspringboot2.repository.ProfessorRepository;
import co.edu.icesi.introspringboot2.service.CourseService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CourseServiceIntegrationTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private EnrollmentService enrollmentService;


    private Professor professor;
    @Autowired
    private StudentService studentService;

    @BeforeEach
    void setup() {
        professor = new Professor();
        professor.setName("Esmesmeris Primero");
        professor = professorService.save(professor);
    }

    @Test
    void createCourse_WhenValid_ReturnsSavedCourse() {
        // Arrange
        Course course = new Course();
        course.setName("Computación en Internet II");
        course.setProfessor(professor);

        // Act
        Course savedCourse = courseService.createCourse(course);

        // Assert
        assertNotNull(savedCourse.getId());
        assertEquals("Computación en Internet II", savedCourse.getName());
        assertNotNull(savedCourse.getProfessor());
        assertEquals(professor.getId(), savedCourse.getProfessor().getId());
        assertDoesNotThrow(() -> courseService.getCourseById(savedCourse.getId()));
        Course foundCourse = courseService.getCourseById(savedCourse.getId());

        assertEquals("Computación en Internet II", foundCourse.getName());
    }

    @Test
    void saveCourse_WhenAlreadyExists_ThrowsException() {
        // Arrange
        Course course = new Course();
        course.setName("Computación en Internet II");
        course.setProfessor(professor);
        Course savedCourse = courseService.createCourse(course);

        // Act & Assert
        Course course2 = new Course();
        course2.setName("Computación en Internet II");
        course2.setProfessor(professor);
        try {
            courseService.createCourse(course2);
        } catch (RuntimeException e) {
            assertEquals("Course already exists", e.getMessage());
        }
    }

    @AfterEach
    void cleanup() {
        courseService.deleteAll();
        professorService.deleteAll();
    }

    @Test
    void getEnrolledStudents_WhenCourseHasStudents_ShouldReturnStudentList(){
        // Arrange
        Course course = new Course();
        course.setName("Computación en Internet II");
        course.setProfessor(professor);
        Course savedCourse = courseService.createCourse(course);

        //cretae 2 students with all atributtes
        Student student1 = new Student();
        student1.setName("Juan");
        student1.setCode("A001");
        student1.setProgram("Ingeniería de Sistemas");
        student1 = studentService.createStudent(student1);

        Student student2 = new Student();
        student2.setName("Pedro");
        student2.setCode("A002");
        student2.setProgram("Ingeniería de Sistemas");
        student2 = studentService.createStudent(student2);

        enrollmentService.enroll("A001","omputación en Internet II");
        enrollmentService.enroll("A002","omputación en Internet II");

    }

}

 */