package br.com.dbc.vemser.pessoaapi.model.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PessoaInputDTO {

    @NotBlank
    @NotNull
    @Schema(description = "Nome da pessoa", example = "Bianca", required = true)
    @Length(min = 2, max = 60)
    private String nome;

    @PastOrPresent
    @NotNull
    @Schema(description = "Data de nascimento da pessoa", example = "14/08/2001", required = true)
    private LocalDate dataNascimento;

    @CPF
    @NotNull
    @Schema(description = "CPF da pessoa", example = "12312312312", required = true)
    @Length(min = 11, max = 11)
    private String cpf;

    @Email
    @NotNull
    @Schema(description = "Email da pessoa", example = "nome@gmail.com", required = true)
    @Length(min = 0, max = 30)
    private String email;

}
