package br.com.dbc.vemser.pessoaapi.model.dto.input;

import br.com.dbc.vemser.pessoaapi.model.entity.TipoPet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PetInputDTO {

    @Nullable
    private Long idPessoa;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Enumerated
    @Column(name = "tipo")
    private TipoPet tipo;

}
