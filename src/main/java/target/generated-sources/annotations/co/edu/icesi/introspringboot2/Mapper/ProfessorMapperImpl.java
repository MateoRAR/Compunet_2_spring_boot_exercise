package co.edu.icesi.introspringboot2.Mapper;

import co.edu.icesi.introspringboot2.DTO.ProfessorDTO;
import co.edu.icesi.introspringboot2.entity.Professor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-22T15:07:53-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ProfessorMapperImpl implements ProfessorMapper {

    @Override
    public Professor toEntity(ProfessorDTO professorDTO) {
        if ( professorDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( professorDTO.getId() );
        professor.setName( professorDTO.getName() );

        return professor;
    }

    @Override
    public ProfessorDTO toDTO(Professor professor) {
        if ( professor == null ) {
            return null;
        }

        ProfessorDTO professorDTO = new ProfessorDTO();

        professorDTO.setId( professor.getId() );
        professorDTO.setName( professor.getName() );

        return professorDTO;
    }
}
