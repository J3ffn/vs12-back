package br.com.dbc.vemser.pessoaapi.model.dto.output.mapeamentoPessoa;

import br.com.dbc.vemser.pessoaapi.model.dto.output.ContatoOutputRelatorioDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.EnderecoOutputRelatorioDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.PetOutputRelatorioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PessoaOutputRelatorioDTO {

    @Schema(description = "ID da pessoa salva no banco", example = "1")
    private Long idPessoa;

    @Schema(description = "Nome da pessoa salva no banco", example = "Bianca")
    private String nome;

    @Schema(description = "Email da pessoa salva no banco", example = "nome@gmail.com")
    private String email;

    @Schema(description = "Enderecos da pessoa salva no banco")
    private Set<EnderecoOutputRelatorioDTO> enderecos;

    @Schema(description = "Contatos da pessoa salva no banco")
    private Set<ContatoOutputRelatorioDTO> contatos;

    @Schema(description = "Nome do pet")
    private Set<PetOutputRelatorioDTO> pet;

}
