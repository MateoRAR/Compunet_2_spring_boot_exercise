package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Professor;
import co.edu.icesi.introspringboot2.repository.ProfessorRepository;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteAll() {
        professorRepository.deleteAll();
    }

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor findById(Long id) {
        if (!isAvailable(id)){
            return professorRepository.findById(id).get();
        } else {
            throw new RuntimeException("Professor not found" + id);
        }
    }

    public boolean isAvailable(long id) {
        return professorRepository.findById(id).isEmpty();
    }

}
