package br.com.dbc.vemser.pessoaapi.model.dto.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContatoOutputDTO {

    @Schema(description = "Id da pessoa", example = "2")
    private Long idContato;

    @Schema(description = "Id da pessoa", example = "2")
    private Long idPessoa;

    @Schema(description = "Tipo do contato", example = "RESIDENCIAL")
    private String tipoContato;

    @Schema(description = "Número de contato", example = "83993256846")
    private String numero;

    @Schema(description = "Descrição de contato", example = "Número do mercado")
    private String descricao;

}
