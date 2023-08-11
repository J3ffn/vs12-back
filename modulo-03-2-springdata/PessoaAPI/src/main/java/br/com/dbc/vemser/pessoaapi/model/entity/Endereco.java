package br.com.dbc.vemser.pessoaapi.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco1", allocationSize = 1)
    private Integer idEndereco;

    @NotNull
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @NotNull
    @Column(name = "TipoEndereco")
    private TipoEndereco tipo;

    @NotBlank
    @NotNull
    @Column(name = "Logradouro")
    private String logradouro;

    @Positive
    @NotNull
    @Column(name = "numero")
    private Integer numero;

    @NotBlank
    @NotNull
    @Column(name = "complemento")
    private String complemento;

    @NotNull
    @Column(name = "cep")
    private String cep;

    @NotNull
    @Column(name = "cidade")
    private String cidade;

    @NotNull
    @Schema(name = "esatado")
    private String estado;

    @NotNull
    @Schema(name = "pais")
    private String pais;

}
