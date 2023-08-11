package br.com.dbc.vemser.pessoaapi.model.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContatoInputDTO {

    @NotNull
    @Schema(description = "Id da pessoa", example = "2", required = true)
    private Integer idPessoa;

    @NotNull
    @NotBlank
    @Schema(description = "Tipo do contato", example = "RESIDENCIAL", required = true, enumAsRef = true)
    private String tipoContato;

    @NotNull
    @Positive
    @Schema(description = "Número de contato", example = "83993256846", required = true)
    private String numero;

    @NotNull
    @NotBlank
    @Schema(description = "Descrição de contato", example = "Número do mercado", required = true)
    private String descricao;

}
