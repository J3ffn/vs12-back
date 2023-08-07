package br.com.dbc.vemser.pessoaapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contato {

    @Positive
    private Integer idContato;

    @NotNull
    private Integer idPessoa;

    @NotNull
    @NotEmpty
    private TipoContato tipoContato;

    @NotNull
    @Positive
    private String numero;

    @NotNull
    @NotBlank
    private String descricao;

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato=" + tipoContato +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
