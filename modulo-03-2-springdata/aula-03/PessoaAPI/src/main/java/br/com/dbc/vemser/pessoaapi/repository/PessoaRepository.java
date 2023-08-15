package br.com.dbc.vemser.pessoaapi.repository;

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

//    @Query(" select new br.com.dbc.vemser.pessoaapi.model.dto.output.PessoaOutputRelatorioDTO.java(" +
//            "p.idPessoa," +
//            "p.contatos" +
//            ")" +
//            "from PESSOA p " +
//            "INNER JOIN CONTATO c " +
//            "where p")
//    List<PessoaOutputRelatorioDTO> findAllWithPessoa();

}
