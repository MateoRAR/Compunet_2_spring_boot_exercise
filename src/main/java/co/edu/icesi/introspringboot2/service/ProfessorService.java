package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.DTO.ProfessorDTO;
import co.edu.icesi.introspringboot2.entity.Professor;

import java.util.List;

public interface ProfessorService {
    ProfessorDTO save(ProfessorDTO professor);

    void deleteAll();

    List<ProfessorDTO> getAllProfessors();

    ProfessorDTO findById(Long id);
}