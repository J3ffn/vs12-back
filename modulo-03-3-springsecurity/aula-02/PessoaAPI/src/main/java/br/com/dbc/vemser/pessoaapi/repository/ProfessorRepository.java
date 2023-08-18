package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.model.entity.Professor;
import br.com.dbc.vemser.pessoaapi.model.entity.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, ProfessorPK> {

    List<Professor> findProfessorsByProfessorPK_IdProfessor(Long idProfessor);

}
