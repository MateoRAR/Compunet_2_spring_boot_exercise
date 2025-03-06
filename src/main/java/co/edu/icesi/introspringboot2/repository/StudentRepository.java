package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
