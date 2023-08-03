package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService) {
        this.contatoRepository = contatoRepository;
    }

    public Contato create(Contato contato) {
//        if (StringUtils.isBlank(contato.getDescricao())) {
//            throw new Exception("Contato inválido");
//        }
        return contatoRepository.create(contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
//        if (ObjectUtils.anyNull(contatoAtualizar)) {
//            throw new Exception("Contato inválido!");
//        }

        Contato contatoRecuperada = getContato(id);

        contatoRecuperada.setIdContato(id);
        contatoRecuperada.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperada.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperada.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperada.setNumero(contatoAtualizar.getNumero());

        return contatoRecuperada;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperada = getContato(id);
        contatoRepository.delete(contatoRecuperada);
    }

    public List<Contato> listByDescricao(String descricao) throws Exception {
//        if (StringUtils.isBlank(descricao)) {
//            throw new Exception("Descrição vazia");
//        }
        return contatoRepository.listByDescricao(descricao);
    }

    public List<Contato> getContatosByIdUsuario(Integer idPessoa) {
        return list().stream().filter(contato -> contato.getIdPessoa().equals(idPessoa)).toList();
    }

    private Contato getContato(Integer id) throws Exception {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
    }

}
