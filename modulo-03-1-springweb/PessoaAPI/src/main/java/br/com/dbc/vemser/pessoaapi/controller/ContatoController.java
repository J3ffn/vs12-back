package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.ContatoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.ContatoOutputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
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
    public ResponseEntity<List<ContatoOutputDTO>> list() {
        return ResponseEntity.ok().body(contatoService.list());
    }

    @GetMapping("/pessoa/{idPessoa}")
    public List<ContatoOutputDTO> contatosByIdPessoa(@Positive @PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.getContatosByIdUsuario(idPessoa);
    }

    @PostMapping
    public ResponseEntity<ContatoOutputDTO> create(@Valid @RequestBody ContatoInputDTO contato) throws EnumException {
        return ResponseEntity.ok().body(contatoService.create(contato));
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoOutputDTO> update(@Positive @PathVariable("idContato") Integer id,
                                          @Valid @RequestBody ContatoInputDTO contatoAtualizar) throws RegraDeNegocioException,  EnumException {
        return ResponseEntity.ok().body(contatoService.update(id, contatoAtualizar));
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@Positive @PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
