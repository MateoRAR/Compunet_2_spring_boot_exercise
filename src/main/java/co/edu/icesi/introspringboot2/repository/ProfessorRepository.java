package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Professor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
