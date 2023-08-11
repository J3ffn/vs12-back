package br.com.dbc.vemser.pessoaapi.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
    @Schema(description = "Id de pessoa", example = "RESIDENCIAL", required = true)
    private Integer idPessoa;

    @NotNull
    @Column(name = "TipoEndereco")
    @Enumerated
    @Schema(description = "Tipo do contato", example = "COMERCIAL", required = true, enumAsRef = true)
    private TipoEndereco tipoEndereco;

    @NotBlank
    @NotNull
    @Column(name = "Logradouro")
    @Length(min = 2, max = 40)
    @Schema(description = "Logradouro do endereço", example = "Rua amaral batista", required = true)
    private String logradouro;

    @Positive
    @NotNull
    @Column(name = "numero")
    @Schema(description = "Número da casa", example = "132", required = true)
    private Integer numero;

    @NotBlank
    @NotNull
    @Column(name = "complemento")
    @Length(min = 2, max = 40)
    @Schema(description = "Complemento sobre a casa", example = "Apartamento", required = true)
    private String complemento;

    @NotNull
    @Column(name = "cep")
    @Length(min = 8, max = 9)
    @Schema(description = "CEP da rua", example = "58970000", required = true)
    private String cep;

    @NotNull
    @Column(name = "cidade")
    @Length(min = 1, max = 20)
    @Schema(description = "Cidade do endereço", example = "João Pessoa", required = true)
    private String cidade;

    @NotNull
    @Column(name = "esatado")
    @Length(min = 1, max = 20)
    @Schema(description = "Estado do endereço", example = "Paraíba", required = true)
    private String estado;

    @NotNull
    @Column(name = "pais")
    @Length(min = 1, max = 20)
    @Schema(description = "País do endereço", example = "RESIDENCIAL", required = true)
    private String pais;


}
