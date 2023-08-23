package br.com.dbc.vemser.pessoaapi.model.dto.output.mapeamentoPessoa;

import br.com.dbc.vemser.pessoaapi.model.entity.Contato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PessoaOutputContatoDTO {

    @Schema(description = "ID da pessoa salva no banco", example = "1", required = true)
    private Long idPessoa;

    @Schema(description = "Nome da pessoa salva no banco", example = "Bianca", required = true)
    private String nome;

    @Schema(description = "Data de nascimento da pessoa salva no banco", example = "2001-08-14", required = true)
    private LocalDate dataNascimento;

    @Schema(description = "CPF da pessoa salva no banco", example = "12312312312", required = true)
    private String cpf;

    @Schema(description = "Email da pessoa salva no banco", example = "nome@gmail.com", required = true)
    private String email;

    @Schema(description = "Contatos da pessoa salva no banco", example = "{}")
    private Set<Contato> contatos;

}
