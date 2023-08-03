package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<Contato>> list() {
        return ResponseEntity.ok().body(contatoService.list());
    }

    @GetMapping("/byname")
    public ResponseEntity<List<Contato>> listByDescricao(@RequestParam("descricao") String descricao) throws Exception {
        return ResponseEntity.ok().body(contatoService.listByDescricao(descricao));
    }

    @GetMapping("/pessoa/{idPessoa}")
    public List<Contato> contatosByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.getContatosByIdUsuario(idPessoa);
    }

    @PostMapping
    public ResponseEntity<Contato> create(@Valid @RequestBody Contato contato) throws Exception {
        return ResponseEntity.ok().body(contatoService.create(contato));
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                                          @Valid @RequestBody Contato contatoAtualizar) throws Exception {
        return ResponseEntity.ok().body(contatoService.update(id, contatoAtualizar));
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
