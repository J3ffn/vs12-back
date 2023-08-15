package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentation.PessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.PessoaInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.mapeamentoPessoa.*;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.utils.PropertieReader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/pessoa")
public class PessoaController implements PessoaControllerDoc {

    private final PessoaService pessoaService;

    private final PropertieReader propertieReader;

    @GetMapping
    public List<PessoaOutputDTO> findAll() {
        return pessoaService.findAll();
    }

    @GetMapping("/byname")
    public List<PessoaOutputDTO> listByName(@NotBlank @RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PostMapping
    public PessoaOutputDTO create(@Valid @RequestBody PessoaInputDTO pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }

    @PutMapping("/{idPessoa}")
    public PessoaOutputDTO update(@Positive @PathVariable("idPessoa") Long id,
                                  @Valid @RequestBody PessoaInputDTO pessoaAtualizar) throws RegraDeNegocioException, MessagingException {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@Positive @PathVariable("idPessoa") Long id) throws RegraDeNegocioException, MessagingException {
        pessoaService.delete(id);
    }

    @GetMapping("/{idPessoa}")
    public PessoaOutputDTO findById(Long id) throws RegraDeNegocioException {
        return pessoaService.findById(id);
    }

    @GetMapping("/ambiente")
    public String getAmbiente() {
        return propertieReader.getAmbiente();
    }

    @GetMapping("/listar-com-enderecos")
    public ResponseEntity<List<PessoaOutputEnderecosDTO>> findPessoasWithEnderecos(@Positive @RequestParam(required = false) Long idPessoa) throws RegraDeNegocioException {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAllWithEnderecos(idPessoa));
    }

    @GetMapping("/listar-com-contatos")
    public ResponseEntity<List<PessoaOutputContatoDTO>> findPessoasWithContatos(@Positive @RequestParam(required = false) Long idContato) throws RegraDeNegocioException {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findPessoasWithContatos(idContato));
    }

    @GetMapping("/listar-com-pets")
    public ResponseEntity<List<PessoaOutputPetsDTO>> findPessoasWithPets(@Positive @RequestParam(required = false) Long idPet) throws RegraDeNegocioException {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findPessoasWithPets(idPet));
    }

    @GetMapping("/pessoa-completo")
    public ResponseEntity<List<PessoaOutputDTO>> findPessoasByIdOrAll(@Positive @RequestParam(required = false) Long idPessoa) throws RegraDeNegocioException {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findPessoaByIdOrAll(idPessoa));
    }

    @GetMapping("/relatorio")
    public ResponseEntity<List<PessoaOutputRelatorioDTO>> findPessoasByIdOrAll()  {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.relatorio());
    }

}
