package br.com.dbc.vemser.pessoaapi.model.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContatoInputDTO {

    @NotNull
    @Schema(description = "Id da pessoa", example = "2", required = true)
    private Long idPessoa;

    @NotNull
    @NotBlank
    @Schema(description = "Tipo do contato", example = "RESIDENCIAL", required = true, enumAsRef = true)
    private String tipoContato;

    @NotNull
    @Positive
    @Length(min = 11, max = 11)
    @Schema(description = "Número de contato", example = "83993256846", required = true)
    private String numero;

    @NotNull
    @NotBlank
    @Schema(description = "Descrição de contato", example = "Número do mercado", required = true)
    private String descricao;

    @NotBlank
    @NotNull
    @Length(min = 2, max = 60)
    @Schema(description = "Nome da pessoa", example = "Bianca", required = true)
    private String nome;

    @PastOrPresent
    @NotNull
    @Schema(description = "Data de nascimento da pessoa", example = "14/08/2001", required = true)
    private LocalDate dataNascimento;

    @CPF
    @NotNull
    @Length(min = 11, max = 11)
    @Schema(description = "CPF da pessoa", example = "12312312312", required = true)
    private String cpf;

    @Email
    @NotNull
    @Length(min = 2, max = 30)
    @Schema(description = "Email da pessoa", example = "nome@gmail.com", required = true)
    private String email;

}
