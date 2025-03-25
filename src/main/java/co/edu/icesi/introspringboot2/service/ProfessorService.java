package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Professor;

public interface ProfessorService {
    Professor save(Professor professor);

    void deleteAll();
}