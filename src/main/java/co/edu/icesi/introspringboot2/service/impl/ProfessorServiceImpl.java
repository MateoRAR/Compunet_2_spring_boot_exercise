package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.DTO.ProfessorDTO;
import co.edu.icesi.introspringboot2.Mapper.ProfessorMapper;
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

    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public ProfessorDTO save(ProfessorDTO professor) {
        if (isAvailable(professor.getId())){
            Professor professor_e = professorMapper.toEntity(professor);
            return professorMapper.toDTO(professorRepository.save(professor_e));
        } else {
            throw new RuntimeException("Professor already exists");
        }
    }

    @Override
    public void deleteAll() {
        professorRepository.deleteAll();
    }

    @Override
    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.findAll().stream().map(professorMapper::toDTO).toList();
    }

    @Override
    public ProfessorDTO findById(Long id) {
        if (!isAvailable(id)){
            return professorMapper.toDTO(professorRepository.findById(id).get());
        } else {
            throw new RuntimeException("Professor not found" + id);
        }
    }

    public boolean isAvailable(long id) {
        return professorRepository.findById(id).isEmpty();
    }

}
