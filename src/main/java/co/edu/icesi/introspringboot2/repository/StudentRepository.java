package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByProgram(String program);

    Optional<Student> findByCode(String code);
}
