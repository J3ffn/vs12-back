package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

//    PessoaR updateByidPessoa(Integer idPessoa, PessoaR pessoa);

    List<Pessoa> findByNome(String nome);
}
