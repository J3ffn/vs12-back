package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.model.entity.Contato;
import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.model.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    private final PessoaRepository pessoaRepository;

    private final EnderecoRepository enderecoRepository;

    private final ContatoRepository contatoRepository;

    @GetMapping("/{pais}")
    public List<Endereco> enderecosByPais(@PathVariable String pais) {
        return enderecoRepository.findEnderecosByPais(pais);
    }

    @GetMapping("/endereco/pessoa/{idPessoa}")
    public List<Endereco> enderecosByIdPessoa(@PathVariable Long idPessoa) {
        return enderecoRepository.findEnderecosByPessoa(idPessoa);
    }

    @GetMapping("/contato/{tipo}")
    public List<Contato> contatosByTipo(@PathVariable String tipo) {
        return contatoRepository.findContatoesByTipoContato(TipoContato.valueOf(tipo));
    }

    @GetMapping("/pessoa/nascidas")
    public List<Pessoa> findPessoasByDataDeNascimento(@RequestParam(name = "inicio") String inicio, @RequestParam(name = "fim") String fim) {
        return pessoaRepository.findByDataNascimentoBetween(LocalDate.parse(inicio), LocalDate.parse(fim));
    }

    @GetMapping("/endereco")
    public List<Endereco> enderecosByCidadeOrPais(@RequestParam(required = false) String cidade, @RequestParam(required = false) String pais) {
        return enderecoRepository.findByPaisOrCidade(cidade, pais);
    }

}
