package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.model.dto.output.ContatoOutputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Contato;
import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Predicate;

@RequiredArgsConstructor

@RestController
@RequestMapping("/paginacao")
public class PaginacaoController {

    private final PessoaRepository pessoaRepository;

    private final EnderecoRepository enderecoRepository;

    private final ContatoRepository contatoRepository;

    @GetMapping("/contato")
    public Page<Contato> contatosPaginadoPelaDescricao(@RequestParam Integer pagina, @RequestParam Integer quantidade) {

        Pageable pageable = PageRequest.of(pagina, quantidade, Sort.by("descricao").descending());
        return contatoRepository.findAll(pageable);
    }

    @GetMapping("/endereco/cep")
    public Page<Endereco> enderecosPaginadosPeloCep(@RequestParam Integer pagina, @RequestParam Integer quantidade) {

        Pageable paginacao = PageRequest.of(pagina, quantidade, Sort.by("cep").descending());
        return enderecoRepository.findAll(paginacao);
    }

    @GetMapping("/endereco/pais")
    public Page<Endereco> enderecosPaginadosPeloPais(@RequestParam Integer pagina, @RequestParam Integer quantidade, @RequestParam String pais) {

        Pageable paginacao = PageRequest.of(pagina, quantidade, Sort.by("pais"));
        return enderecoRepository.findEnderecosByPaisPaginada(paginacao, pais);
    }

}
