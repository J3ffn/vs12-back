package br.com.dbc.vemser.pessoaapi.model.dto.output;

import br.com.dbc.vemser.pessoaapi.model.entity.ProfessorPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProfessorOutputDTO {

    @EmbeddedId
    private ProfessorPK professorPK;

    private String nome;

    private Double salario;

}
