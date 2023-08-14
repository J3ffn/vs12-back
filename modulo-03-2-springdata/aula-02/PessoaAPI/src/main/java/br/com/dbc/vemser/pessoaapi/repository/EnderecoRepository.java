package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "SELECT e.* FROM VEM_SER.PESSOA_X_PESSOA_ENDERECO ppe INNER JOIN VEM_SER.ENDERECO e on e.ID_ENDERECO = ppe.ID_ENDERECO WHERE ppe.ID_PESSOA = :id", nativeQuery = true)
    List<Endereco> findByIdWithEnderecos(@Param("id") Long id);

//    ContatoR updateBy(EnderecoR endereco);

//    List<Endereco> findEnderecosByPessoa(Long idPessoa);

}
