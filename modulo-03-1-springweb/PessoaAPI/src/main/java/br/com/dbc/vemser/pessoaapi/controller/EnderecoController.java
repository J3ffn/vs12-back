package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> list() {
        return ResponseEntity.ok().body(enderecoService.list());
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Integer idEndereco) throws Exception {
        return ResponseEntity.ok().body(enderecoService.getEnderecoById(idEndereco));
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<Endereco>> getEnderecosByIdPessoa(@PathVariable Integer idPessoa) {
        return ResponseEntity.ok().body(enderecoService.getEnderecosByIdPessoa(idPessoa));
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable Integer idPessoa, @Valid @RequestBody Endereco endereco) {
        return ResponseEntity.ok().body(enderecoService.create(idPessoa, endereco));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable Integer idEndereco, @Valid @RequestBody Endereco endereco) throws Exception {
        Endereco enderecoAlterado = enderecoService.update(idEndereco, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoAlterado);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
    }

}
