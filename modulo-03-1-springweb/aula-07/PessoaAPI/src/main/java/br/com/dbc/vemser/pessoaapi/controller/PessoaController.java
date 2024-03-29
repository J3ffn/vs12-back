package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.doc.PessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.PessoaInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.PessoaOutputDTO;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.utils.PropertieReader;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController implements PessoaControllerDoc {

    private final PessoaService pessoaService;

    private final PropertieReader propertieReader;

    @Autowired
    public PessoaController(PessoaService pessoaService, PropertieReader propertieReader) {
        this.pessoaService = pessoaService;
        this.propertieReader = propertieReader;
    }

    @GetMapping
    public ResponseEntity<List<PessoaOutputDTO>> list() {
        return ResponseEntity.ok().body(pessoaService.list());
    }

    @GetMapping("/byname")
    public ResponseEntity<List<PessoaOutputDTO>> listByName(@NotBlank @RequestParam("nome") String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listByName(nome));
    }

    @PostMapping
    public ResponseEntity<PessoaOutputDTO> create(@Valid @RequestBody PessoaInputDTO pessoa) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.create(pessoa));
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaOutputDTO> update(@Positive @PathVariable("idPessoa") Integer id,
                                  @Valid @RequestBody PessoaInputDTO pessoaAtualizar) throws RegraDeNegocioException, MessagingException {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@Positive @PathVariable("idPessoa") Integer id) throws RegraDeNegocioException, MessagingException {
        pessoaService.delete(id);
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaOutputDTO> findById(Integer id) throws RegraDeNegocioException {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findById(id));
    }

    @GetMapping("/ambiente")
    public String getAmbiente() {
        return propertieReader.getAmbiente();
    }

}
