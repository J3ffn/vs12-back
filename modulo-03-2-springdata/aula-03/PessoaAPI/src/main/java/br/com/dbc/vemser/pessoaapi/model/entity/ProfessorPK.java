package br.com.dbc.vemser.pessoaapi.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter

@Embeddable
public class ProfessorPK implements Serializable {

//    @Column(name="id_professor")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFESSOR_SEQ")
//    @SequenceGenerator(name = "PROFESSOR_SEQ", sequenceName = "seq_professor", allocationSize = 1)
//    private Long idProfessor;

    @Column(name="id_professor")
    private Long idProfessor;

    @Column(name="id_universidade")
    private Long idUniversidade;
}
