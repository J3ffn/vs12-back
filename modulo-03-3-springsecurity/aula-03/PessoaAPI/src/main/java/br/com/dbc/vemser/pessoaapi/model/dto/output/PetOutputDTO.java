package br.com.dbc.vemser.pessoaapi.model.dto.output;

import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.model.entity.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PetOutputDTO {

    @Schema(description = "Id do pet", example = "5")
    private Long idPet;

    @Schema(description = "Id referente a pessoa", example = "3")
    private Pessoa pessoa;

    @Schema(description = "Nome referente ao pet", example = "Rusk")
    private String nome;

    @Schema(description = "Tipo do pet", example = "CACHORRO")
    private TipoPet tipo;
}
