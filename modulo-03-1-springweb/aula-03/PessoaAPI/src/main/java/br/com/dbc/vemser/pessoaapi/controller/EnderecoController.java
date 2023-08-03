package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public Endereco getEnderecoById(@PathVariable Integer idEndereco) throws Exception {
        return enderecoService.getEnderecoById(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> getEnderecosByIdPessoa(@PathVariable Integer idPessoa) {
        return enderecoService.getEnderecosByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable Integer idPessoa, @RequestBody Endereco endereco) {
        return enderecoService.create(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable Integer idEndereco, @RequestBody Endereco endereco) throws Exception {
        return enderecoService.update(idEndereco, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
    }
}
