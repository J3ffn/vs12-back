package br.com.dbc.vemser.pessoaapi.model.dto.output;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class PessoaOutputDTO {

    @NotBlank
    @NotNull
    private String nome;

    @PastOrPresent
    @NotNull
    @DateTimeFormat
    private LocalDate dataNascimento;

    @CPF
    @NotNull
    private String cpf;

}
