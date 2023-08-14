package br.com.dbc.vemser.pessoaapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Long idPessoa;

    @NotBlank
    @NotNull
    @Length(min = 2, max = 60)
    @Schema(description = "Nome da pessoa", example = "Bianca", required = true)
    private String nome;

    @PastOrPresent
    @NotNull
    @Schema(description = "Data de nascimento da pessoa", example = "14/08/2001", required = true)
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @CPF
    @NotNull
    @Length(min = 11, max = 11)
    @Schema(description = "CPF da pessoa", example = "12312312312", required = true)
    private String cpf;

    @Email
    @NotNull
    @Length(min = 2, max = 30)
    @Schema(description = "Email da pessoa", example = "nome@gmail.com", required = true)
    @Column(name = "email", length = 60, nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<Endereco> enderecos;

    @JsonIgnoreProperties("pessoas")
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contato> contatos;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pet", referencedColumnName = "id_pet")
    private Pet pet;

    public Integer getIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }


}
