package br.com.dbc.vemser.pessoaapi.model.dto.output;

import br.com.dbc.vemser.pessoaapi.model.dto.input.ContatoInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContatoOutputDTO extends ContatoInputDTO {

    @NotNull
    private Integer idPessoa;

    @NotNull
    @NotBlank
    private String tipoContato;

    @NotNull
    @Positive
    private String numero;

    @NotNull
    @NotBlank
    private String descricao;


}
