package br.com.dbc.vemser.pessoaapi.model.dto.input;

import br.com.dbc.vemser.pessoaapi.model.entity.ProfessorPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProfessorInputDTO {

    @Positive
    @NotNull
    ProfessorPK professorPK;

    @Column(name = "nome")
    @NotNull
    @NotBlank
    private String nome;

    @Column(name = "salario")
    @NotNull
    @NotBlank
    private Double salario;

}
