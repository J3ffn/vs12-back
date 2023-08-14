package br.com.dbc.vemser.pessoaapi.model.dto.output;

import br.com.dbc.vemser.pessoaapi.model.entity.PetSerialize;
import br.com.dbc.vemser.pessoaapi.model.entity.TipoPet;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PetOutputDTO {

    private Long idPet;

    private Long pessoa;

    private String nome;

    private TipoPet tipo;
}
