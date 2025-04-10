package co.edu.icesi.introspringboot2.Mapper;

import co.edu.icesi.introspringboot2.DTO.ProfessorDTO;
import co.edu.icesi.introspringboot2.entity.Professor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-10T14:56:12-0500",
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

        if ( professorDTO.getId() != null ) {
            professor.setId( Long.parseLong( professorDTO.getId() ) );
        }
        professor.setName( professorDTO.getName() );

        return professor;
    }
}
