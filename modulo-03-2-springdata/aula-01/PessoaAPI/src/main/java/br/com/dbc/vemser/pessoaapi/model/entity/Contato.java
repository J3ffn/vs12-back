package br.com.dbc.vemser.pessoaapi.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "CONTATO")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTATO")
    @SequenceGenerator(name = "SEQ_CONTATO", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Long idContato;

    @Column(name = "id_pessoa")
    @NotNull
    @Schema(description = "Id da pessoa", example = "2", required = true)
    private Number idPessoa;

    @Column(name = "tipo_Contato")
    @NotNull
    @NotBlank
    @Length(min = 2, max = 20)
    @Schema(description = "Tipo do contato", example = "RESIDENCIAL", required = true, enumAsRef = true)
    private String tipoContato;

    @Column(name = "numero")
    @NotNull
    @Positive
    @Length(min = 11, max = 11)
    @Schema(description = "Número de contato", example = "83993256846", required = true)
    private String numero;

    @Column(name = "descricao")
    @NotNull
    @NotBlank
    @Length(min = 2, max = 40)
    @Schema(description = "Descrição de contato", example = "Número do mercado", required = true)
    private String descricao;

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato=" + tipoContato +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
