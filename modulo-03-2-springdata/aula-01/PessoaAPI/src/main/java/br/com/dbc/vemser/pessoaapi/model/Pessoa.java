package br.com.dbc.vemser.pessoaapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa1", allocationSize = 1)
    private Long idPessoa;

    @NotBlank
    @NotNull
    @Length(min = 2, max = 60)
    @Schema(description = "Nome da pessoa", example = "Bianca", required = true)
    private String nome;

    @PastOrPresent
    @NotNull
    @Schema(description = "Data de nascimento da pessoa", example = "14/08/2001", required = true)
    private LocalDate dataNascimento;

    @CPF
    @NotNull
    @Length(min = 11, max = 11)
    @Schema(description = "CPF da pessoa", example = "12312312312", required = true)
    private String cpf;

    @Email
    @NotNull
    @Length(min = 0, max = 30)
    @Schema(description = "Email da pessoa", example = "nome@gmail.com", required = true)
    private String email;

    public Integer getIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
