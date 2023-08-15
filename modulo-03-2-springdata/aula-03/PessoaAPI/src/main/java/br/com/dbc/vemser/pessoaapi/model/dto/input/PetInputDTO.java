package br.com.dbc.vemser.pessoaapi.model.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PetInputDTO {

    @Nullable
    private Long idPessoa;

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "Tipo não pode ser nulo")
    private String tipo;

}
