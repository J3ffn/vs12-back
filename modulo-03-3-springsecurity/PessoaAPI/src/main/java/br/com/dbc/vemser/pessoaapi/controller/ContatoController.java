package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentation.ContatoControllerDoc;
import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.ContatoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.ContatoOutputDTO;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/contato")
public class ContatoController implements ContatoControllerDoc {

    private final ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<ContatoOutputDTO>> list() {
        return ResponseEntity.ok().body(contatoService.findAll());
    }

    @GetMapping("/pessoa/{idPessoa}")
    public List<ContatoOutputDTO> contatosByIdPessoa(@Positive @PathVariable("idPessoa") Long idPessoa) {
        return contatoService.getContatosByIdUsuario(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoOutputDTO> create(@PathVariable Long idPessoa, @Valid @RequestBody ContatoInputDTO contato) throws EnumException, RegraDeNegocioException {
        return ResponseEntity.ok().body(contatoService.create(idPessoa, contato));
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoOutputDTO> update(@Positive @PathVariable("idContato") Long id,
                                                   @Valid @RequestBody ContatoInputDTO contatoAtualizar) throws RegraDeNegocioException, EnumException {
        return ResponseEntity.ok().body(contatoService.update(id, contatoAtualizar));
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@Positive @PathVariable("idContato") Long id) throws RegraDeNegocioException {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar-com-enderecos")
    public ResponseEntity<List<ContatoOutputDTO>>  findAllContatoWithEndereco() {
        return this.list();
    }

}
