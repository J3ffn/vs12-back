package br.com.dbc.vemser.pessoaapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "ENDERECO")
public class Endereco {

    @Id
    @Column(name = "id_endereco")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco", allocationSize = 1)
    private Long idEndereco;

    @NotNull
    @Column(name = "Tipo_Endereco")
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    @NotBlank
    @NotNull
    @Column(name = "Logradouro")
    @Length(min = 2, max = 40)
    private String logradouro;

    @NotNull
    @Column(name = "numero")
    private Long numero;

    @NotBlank
    @NotNull
    @Column(name = "complemento")
    @Length(min = 2, max = 40)
    private String complemento;

    @NotNull
    @Column(name = "cep")
    @Length(min = 8, max = 9)
    private String cep;

    @NotNull
    @Column(name = "cidade")
    @Length(min = 1, max = 20)
    private String cidade;

    @NotNull
    @Column(name = "esatado")
    @Length(min = 1, max = 20)
    private String estado;

    @NotNull
    @Column(name = "pais")
    @Length(min = 1, max = 20)
    private String pais;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<Pessoa> pessoas = new HashSet<>();


}
