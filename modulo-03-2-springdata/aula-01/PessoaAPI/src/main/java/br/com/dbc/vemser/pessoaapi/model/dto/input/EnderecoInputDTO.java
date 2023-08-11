package br.com.dbc.vemser.pessoaapi.model.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnderecoInputDTO {

    @Nullable
    @Schema(description = "Id de pessoa", example = "RESIDENCIAL", required = true)
    private Integer idPessoa;

    @NotNull
    @Schema(description = "Tipo do contato", example = "COMERCIAL", required = true, enumAsRef = true)
    private String tipo;

    @NotBlank
    @NotNull
    @Schema(description = "Logradouro do endereço", example = "Rua amaral batista", required = true)
    private String logradouro;

    @Positive
    @NotNull
    @Schema(description = "Número da casa", example = "132", required = true)
    private Integer numero;

    @NotBlank
    @NotNull
    @Schema(description = "Complemento sobre a casa", example = "Apartamento", required = true)
    private String complemento;

    @NotNull
    @Schema(description = "CEP da rua", example = "58970000", required = true)
    private String cep;

    @NotNull
    @Schema(description = "Cidade do endereço", example = "João Pessoa", required = true)
    private String cidade;

    @NotNull
    @Schema(description = "Estado do endereço", example = "Paraíba", required = true)
    private String estado;

    @NotNull
    @Schema(description = "País do endereço", example = "RESIDENCIAL", required = true)
    private String pais;

}
