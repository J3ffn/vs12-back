package br.com.dbc.vemser.pessoaapi.model.dto.output;

import br.com.dbc.vemser.pessoaapi.model.entity.Contato;
import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.model.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PessoaOutputEnderecosDTO {

    private Long idPessoa;

    private String nome;

    private LocalDate dataNascimento;

    private String cpf;

    private String email;

    private Set<Endereco> enderecos;

}
