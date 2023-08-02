package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private ContatoService contatoService;

    @Autowired
    public ContatoController() {
        contatoService = new ContatoService();
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public List<Contato> listByDescricao(@RequestParam("descricao") String descricao) {
        return contatoService.listByDescricao(descricao);
    }

    @GetMapping("/{idPessoa}/all")
    public List<Contato> contatosByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return list().stream().filter(contato -> contato.getIdPessoa().equals(idPessoa)).toList();
    }

    @PostMapping // POST localhost:8080/pessoa
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}
