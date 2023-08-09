package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.model.entity.Contato;
import br.com.dbc.vemser.pessoaapi.model.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {

    private static List<Contato> listaContato;
    private AtomicInteger COUNTER;

    public ContatoRepository() {
        listaContato = new ArrayList<>();
        COUNTER = new AtomicInteger();
        listaContato.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, TipoContato.COMERCIAL, "12345678910", "Mercado"));
        listaContato.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, TipoContato.RESIDENCIAL, "12345678911", "Casa de Ana"));
        listaContato.add(new Contato(COUNTER.incrementAndGet() /*3*/, 3, TipoContato.COMERCIAL, "12345678912", "Pizzaria"));
        listaContato.add(new Contato(COUNTER.incrementAndGet() /*4*/, 4, TipoContato.RESIDENCIAL, "12345678916", "Casa do João"));
        listaContato.add(new Contato(COUNTER.incrementAndGet() /*5*/, 5, TipoContato.COMERCIAL, "12345678917", "Farmácia"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContato.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContato;
    }

    public void delete(Contato contato) {
        listaContato.remove(contato);
    }

    public List<Contato> listByDescricao(String descricao) {
        return listaContato.stream()
                .filter(contato -> contato.getDescricao().toUpperCase().contains(descricao.toUpperCase()))
                .collect(Collectors.toList());
    }

}
