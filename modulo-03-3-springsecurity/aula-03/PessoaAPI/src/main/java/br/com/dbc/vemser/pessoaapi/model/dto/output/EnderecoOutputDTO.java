package br.com.dbc.vemser.pessoaapi.model.dto.output;

import br.com.dbc.vemser.pessoaapi.model.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnderecoOutputDTO {

    @Schema(description = "ID da pessoa", example = "2")
    private Long idEndereco;

    @Schema(description = "Tipo do contato", example = "COMERCIAL")
    private TipoEndereco tipoEndereco;

    @Schema(description = "Logradouro do endereço", example = "Rua amaral batista")
    private String logradouro;

    @Schema(description = "Número da casa", example = "132")
    private Integer numero;

    @Schema(description = "Complemento sobre a casa", example = "Apartamento")
    private String complemento;

    @Schema(description = "CEP da rua", example = "58970000")
    private String cep;

    @Schema(description = "Cidade do endereço", example = "João Pessoa")
    private String cidade;

    @Schema(description = "Estado do endereço", example = "Paraíba")
    private String estado;

    @Schema(description = "País do endereço", example = "RESIDENCIAL")
    private String pais;
}
