package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.model.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {
    public static List<Endereco> listaEnderecos;
    private AtomicInteger COUNTER;

    public EnderecoRepository() {
        listaEnderecos = new ArrayList<>();
        COUNTER = new AtomicInteger();
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "logradouro teste", 200,
                "complemento teste", "58970000", "Conceição", "Paraíba", "Brasil"));
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }

//    public List<Endereco> listByDescricao(String descricao) {
//        return listaEnderecos.stream()
//                .filter(endereco -> endereco.getDescricao().toUpperCase().contains(descricao.toUpperCase()))
//                .collect(Collectors.toList());
//    }

}
