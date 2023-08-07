package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.EnderecoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
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
        List<Endereco> listaEnderecos = enderecoService.list();
        return ResponseEntity.ok().body(listaEnderecos);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> getEnderecoById(@Positive @PathVariable Integer idEndereco) throws Exception {
        Endereco enderecoById = enderecoService.getEnderecoById(idEndereco);
        return ResponseEntity.ok().body(enderecoById);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<Endereco>> getEnderecosByIdPessoa(@Positive @PathVariable Integer idPessoa) {
        List<Endereco> enderecosByIdUsuario = enderecoService.getEnderecosByIdPessoa(idPessoa);
        return ResponseEntity.ok().body(enderecosByIdUsuario);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@Positive @PathVariable Integer idPessoa, @Valid @RequestBody EnderecoInputDTO endereco) throws Exception {
        Endereco enderecoCriado = enderecoService.create(idPessoa, endereco);
        return ResponseEntity.ok().body(enderecoCriado);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@Positive @PathVariable Integer idEndereco, @Valid @RequestBody EnderecoInputDTO endereco) throws RegraDeNegocioException, EnumException {
        Endereco enderecoAlterado = enderecoService.update(idEndereco, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoAlterado);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@Positive @PathVariable Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
    }

}
