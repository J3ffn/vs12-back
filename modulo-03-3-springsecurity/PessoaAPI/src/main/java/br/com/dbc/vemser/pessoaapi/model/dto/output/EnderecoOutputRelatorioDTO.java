package br.com.dbc.vemser.pessoaapi.model.dto.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnderecoOutputRelatorioDTO {

    @Schema(description = "CEP da rua", example = "58970000")
    private String cep;

    @Schema(description = "Cidade do endereço", example = "João Pessoa")
    private String cidade;

    @Schema(description = "Estado do endereço", example = "Paraíba")
    private String estado;

    @Schema(description = "País do endereço", example = "RESIDENCIAL")
    private String pais;

}
