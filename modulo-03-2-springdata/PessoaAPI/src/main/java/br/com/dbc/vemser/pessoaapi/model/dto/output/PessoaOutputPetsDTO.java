package br.com.dbc.vemser.pessoaapi.model.dto.output;

import br.com.dbc.vemser.pessoaapi.model.entity.Pet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PessoaOutputPetsDTO {

    @Schema(description = "ID da pessoa salva no banco", example = "1")
    private Long idPessoa;

    @Schema(description = "Nome da pessoa salva no banco", example = "Bianca")
    private String nome;

    @Schema(description = "Data de nascimento da pessoa salva no banco", example = "2001-08-14")
    private LocalDate dataNascimento;

    @Schema(description = "CPF da pessoa salva no banco", example = "12312312312")
    private String cpf;

    @Schema(description = "Email da pessoa salva no banco", example = "nome@gmail.com")
    private String email;

    @Schema(description = "Pets da pessoa salva no banco", example = "{}")
    private Pet pet;

}
