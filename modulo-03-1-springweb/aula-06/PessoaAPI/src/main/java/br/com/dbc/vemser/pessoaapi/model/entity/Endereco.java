package br.com.dbc.vemser.pessoaapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {

    @Positive
    private Integer idEndereco;

    @NotNull
    private Integer idPessoa;

    @NotNull
    private TipoEndereco tipo;

    @NotBlank
    @NotNull
    private String logradouro;

    @Positive
    @NotNull
    private Integer numero;

    @NotBlank
    @NotNull
    private String complemento;

    @NotNull
    private String cep;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;

}
