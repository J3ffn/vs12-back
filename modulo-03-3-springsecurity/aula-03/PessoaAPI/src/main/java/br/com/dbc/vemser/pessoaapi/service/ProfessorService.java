package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.entity.Professor;
import br.com.dbc.vemser.pessoaapi.model.entity.ProfessorPK;
import br.com.dbc.vemser.pessoaapi.model.dto.input.ProfessorInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.ProfessorOutputDTO;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProfessorService {

    private ProfessorRepository professorRepository;

    private ObjectMapper objectMapper;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, ObjectMapper objectMapper) {
        this.professorRepository = professorRepository;
        this.objectMapper = objectMapper;
    }

    public ProfessorOutputDTO save(ProfessorInputDTO professorRecebido) {
        Professor professor = objectMapper.convertValue(professorRecebido, Professor.class);

        professor = professorRepository.save(professor);
        return objectMapper.convertValue(professor, ProfessorOutputDTO.class);
    }

    public void delete(ProfessorPK idProfessor) {
        professorRepository.deleteById(idProfessor);
    }

    public List<ProfessorOutputDTO> findByIdProfessor(Long idProfessor) throws RegraDeNegocioException {
        List<ProfessorOutputDTO> professores = professorRepository
                              .findProfessorsByProfessorPK_IdProfessor(idProfessor)
                              .stream()
                .map(this::convertProfessorToProfessorOutputDTO)
                .toList();

        if (professores.isEmpty())
            throw new RegraDeNegocioException("Nenhum professor foi encontrado!");

        return professores;
    }

    public List<ProfessorOutputDTO> findProfessorByIdUniversidade(Long idUniversidade) throws RegraDeNegocioException {
        List<ProfessorOutputDTO> professores = professorRepository
                .findProfessorsByProfessorPK_IdProfessor(idUniversidade)
                .stream()
                .map(this::convertProfessorToProfessorOutputDTO)
                .toList();

        if (professores.isEmpty())
            throw new RegraDeNegocioException("Nenhum professor foi encontrado!");

        return professores;
    }

    public List<ProfessorOutputDTO> findAll() throws NotFoundException {
        List<ProfessorOutputDTO> lista = professorRepository
                .findAll()
                .stream()
                .map(professor -> objectMapper.convertValue(professor, ProfessorOutputDTO.class))
                .toList();

        if (lista == null) {
            throw new NotFoundException("Não há nada");
        }
        return lista;
    }

    private ProfessorOutputDTO convertProfessorToProfessorOutputDTO(Professor professor) {
        return objectMapper.convertValue(professor, ProfessorOutputDTO.class);
    }

}
