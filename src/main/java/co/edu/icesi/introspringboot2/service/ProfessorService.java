package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Professor;

import java.util.List;

public interface ProfessorService {
    Professor save(Professor professor);

    void deleteAll();

    List<Professor> getAllProfessors();

    Professor findById(Long id);
}