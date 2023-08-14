package br.com.dbc.vemser.pessoaapi.model.dto.input;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContatoInputDTO {

    @Nullable
    @Schema(description = "Id da pessoa", example = "2", required = true)
    private Long idPessoa;

    @NotNull
    @NotBlank
    @Schema(description = "Tipo do contato", example = "RESIDENCIAL", required = true, enumAsRef = true)
    private String tipoContato;

    @NotNull
    @Positive
    @Length(min = 11, max = 11)
    @Schema(description = "Número de contato", example = "83993256846", required = true)
    private String numero;

    @NotNull
    @NotBlank
    @Schema(description = "Descrição de contato", example = "Número do mercado", required = true)
    private String descricao;


}
