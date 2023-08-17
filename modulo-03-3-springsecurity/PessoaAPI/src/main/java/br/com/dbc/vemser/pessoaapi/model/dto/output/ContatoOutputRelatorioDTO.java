package br.com.dbc.vemser.pessoaapi.model.dto.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContatoOutputRelatorioDTO {

    @Schema(description = "Número de contato", example = "83993256846")
    private String numero;

}
