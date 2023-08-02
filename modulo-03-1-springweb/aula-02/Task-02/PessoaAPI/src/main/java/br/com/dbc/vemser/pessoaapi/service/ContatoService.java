package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    @Autowired
    public ContatoService() {
        contatoRepository = new ContatoRepository();
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato){
        return contatoRepository.create(contato);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoRepository.list();
    }

    @PutMapping("/{id}")
    public Contato update(@PathVariable Integer id, @RequestBody Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperada = getContato(id);

        contatoRecuperada.setIdContato(id);
        contatoRecuperada.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperada.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperada.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperada.setNumero(contatoAtualizar.getNumero());

        return contatoRecuperada;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        Contato contatoRecuperada = getContato(id);
        contatoRepository.delete(contatoRecuperada);
    }

    @GetMapping(params = {"nome"})
    public List<Contato> listByDescricao(@RequestParam String nome) {
        return contatoRepository.listByDescricao(nome);
    }

    private Contato getContato(Integer id) throws Exception {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado!"));
    }

}
