package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.model.dto.output.mapeamentoPessoa.PessoaOutputRelatorioDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("Select p From PESSOA p where (:idPessoa is null or p.idPessoa = :idPessoa)")
    List<Pessoa> findAllComOptional(@Param("idPessoa") Long idPessoa);

    List<Pessoa> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataTermino);

    List<Pessoa> findByNome(String nome);

    
    @Query(value = "select new br.com.dbc.vemser.pessoaapi.model.dto.output.mapeamentoPessoa.PessoaOutputRelatorioDTO(" +
            "p.idPessoa," +
            "p.nome," +
            "p.email," +
            "p.enderecos," +
            "p.contatos," +
            "p.pet)" +
            "from PESSOA p " +
            "INNER JOIN p.contatos c " +
            "WHERE c.descricao = :descricao")
    List<PessoaOutputRelatorioDTO> findAllWithPessoa();

}
