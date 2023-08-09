package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.doc.EnderecoControllerDoc;
import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.EnderecoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.EnderecoOutputDTO;
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
public class EnderecoController implements EnderecoControllerDoc {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoOutputDTO>> list() {
        return ResponseEntity.ok().body(enderecoService.list());
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<EnderecoOutputDTO> getEnderecoById(@Positive @PathVariable Integer idEndereco) throws Exception {
        EnderecoOutputDTO enderecoById = enderecoService.getEnderecoById(idEndereco);
        return ResponseEntity.ok().body(enderecoById);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoOutputDTO>> getEnderecosByIdPessoa(@Positive @PathVariable Integer idPessoa) {
        List<EnderecoOutputDTO> enderecosByIdUsuario = enderecoService.getEnderecosByIdPessoa(idPessoa);
        return ResponseEntity.ok().body(enderecosByIdUsuario);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoOutputDTO> create(@Positive @PathVariable Integer idPessoa, @Valid @RequestBody EnderecoInputDTO endereco) throws Exception {
        EnderecoOutputDTO enderecoCriado = enderecoService.create(idPessoa, endereco);
        return ResponseEntity.ok().body(enderecoCriado);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoOutputDTO> update(@Positive @PathVariable Integer idEndereco, @Valid @RequestBody EnderecoInputDTO endereco) throws RegraDeNegocioException, EnumException {
        EnderecoOutputDTO enderecoAlterado = enderecoService.update(idEndereco, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoAlterado);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@Positive @PathVariable Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
    }

}
