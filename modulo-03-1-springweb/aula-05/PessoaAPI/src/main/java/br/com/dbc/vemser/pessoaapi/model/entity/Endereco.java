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

    private Integer idEndereco;

    private Integer idPessoa;

    private TipoEndereco tipo;

    private String logradouro;

    private Integer numero;

    private String complemento;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;

}
