package br.com.dbc.vemser.pessoaapi.model.dto.output;

import br.com.dbc.vemser.pessoaapi.model.dto.input.PessoaInputDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PessoaOutputDTO extends PessoaInputDTO {

    @Schema(description = "ID da pessoa", example = "RESIDENCIAL", required = true)
    private Integer idPessoa;


}
