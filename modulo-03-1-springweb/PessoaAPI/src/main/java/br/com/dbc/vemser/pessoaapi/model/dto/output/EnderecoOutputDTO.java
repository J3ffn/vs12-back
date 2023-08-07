package br.com.dbc.vemser.pessoaapi.model.dto.output;

import br.com.dbc.vemser.pessoaapi.model.dto.input.EnderecoInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnderecoOutputDTO extends EnderecoInputDTO {

    @Nullable
    private Integer idPessoa;

    @NotNull
    private String tipo;

    @NotBlank
    @NotNull
    private String logradouro;

    @Positive
    @NotNull
    private Integer numero;

    @NotBlank
    @NotNull
    private String complemento;

    @NotNull
    private String cep;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;


}
