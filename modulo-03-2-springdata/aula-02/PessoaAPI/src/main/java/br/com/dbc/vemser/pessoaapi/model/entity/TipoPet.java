package br.com.dbc.vemser.pessoaapi.model.entity;

public enum TipoPet {
    CACHORRO(1), GATO(2), GUAXINIM(3);

    private Integer codigo;

    TipoPet(int codigo) {
        this.codigo = codigo;
    }
}
