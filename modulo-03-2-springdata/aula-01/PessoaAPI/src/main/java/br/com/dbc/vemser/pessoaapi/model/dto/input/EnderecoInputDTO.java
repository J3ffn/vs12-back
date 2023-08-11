package br.com.dbc.vemser.pessoaapi.model.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnderecoInputDTO {

    @Schema(description = "Id de pessoa", example = "RESIDENCIAL", required = true)
    @NotNull
    @Column(name = "id_pessoa")
    private Long idPessoa;

    @NotNull
    @Schema(description = "Tipo do contato", example = "COMERCIAL", required = true, enumAsRef = true)
    private String tipoEndereco;

    @NotBlank
    @NotNull
    @Schema(description = "Logradouro do endereço", example = "Rua amaral batista", required = true)
    @Length(min = 2, max = 40)
    private String logradouro;

    @Positive
    @NotNull
    @Schema(description = "Número da casa", example = "132", required = true)
    @Column(name = "numero")
    private Integer numero;

    @NotBlank
    @NotNull
    @Schema(description = "Complemento sobre a casa", example = "Apartamento", required = true)
    @Length(min = 2, max = 40)
    private String complemento;

    @NotNull
    @Schema(description = "CEP da rua", example = "58970000", required = true)
    @Length(min = 8, max = 9)
    private String cep;

    @NotNull
    @Schema(description = "Cidade do endereço", example = "João Pessoa", required = true)
    @Length(min = 1, max = 20)
    private String cidade;

    @NotNull
    @Schema(description = "Estado do endereço", example = "Paraíba", required = true)
    @Length(min = 1, max = 20)
    private String estado;

    @NotNull
    @Schema(description = "País do endereço", example = "RESIDENCIAL", required = true)
    @Length(min = 1, max = 20)
    private String pais;

}
