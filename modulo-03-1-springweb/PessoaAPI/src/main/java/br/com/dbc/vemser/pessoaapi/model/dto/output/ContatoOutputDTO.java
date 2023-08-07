package br.com.dbc.vemser.pessoaapi.model.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContatoOutputDTO {

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
