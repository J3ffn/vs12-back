package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.PessoaInputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname")
    public List<Pessoa> listByName(@NotBlank @RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PostMapping
    public Pessoa create(@Valid @RequestBody PessoaInputDTO pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }

    @PutMapping("/{idPessoa}")
    public Pessoa update(@Positive @PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody PessoaInputDTO pessoaAtualizar) throws RegraDeNegocioException {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@Positive @PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }

    @GetMapping("/{idPessoa}")
    public Pessoa findById(Integer id) throws RegraDeNegocioException {
        return pessoaService.findById(id);
    }

}
