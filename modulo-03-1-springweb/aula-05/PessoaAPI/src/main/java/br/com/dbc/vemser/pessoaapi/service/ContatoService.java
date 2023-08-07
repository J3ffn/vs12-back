package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.ContatoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.ContatoOutputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Contato;
import br.com.dbc.vemser.pessoaapi.model.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository, ObjectMapper objectMapper) {
        this.contatoRepository = contatoRepository;
        this.objectMapper = objectMapper;
    }

    public ContatoOutputDTO create(ContatoInputDTO contato) throws EnumException {

        checarEnum(contato.getTipoContato());

        Contato contatoConvertido = objectMapper.convertValue(contato, Contato.class);

        return objectMapper.convertValue(contatoRepository.create(contatoConvertido), ContatoOutputDTO.class);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public ContatoOutputDTO update(Integer id, ContatoInputDTO contatoAtualizar) throws RegraDeNegocioException, EnumException {

        TipoContato tipoContato = checarEnum(contatoAtualizar.getTipoContato());

        Contato contatoRecuperado = getContato(id);

        contatoRecuperado.setIdContato(id);
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoContato(tipoContato);
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());

        return objectMapper.convertValue(contatoRecuperado, ContatoOutputDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperada = getContato(id);
        contatoRepository.delete(contatoRecuperada);
    }

    public List<ContatoOutputDTO> getContatosByIdUsuario(Integer idPessoa) {
        return list().stream().filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .map(contato -> objectMapper.convertValue(contato, ContatoOutputDTO.class))
                .toList();
    }

    private Contato getContato(Integer id) throws RegraDeNegocioException {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
    }

    private TipoContato checarEnum(String tipo) throws EnumException {
        try {
            return TipoContato.valueOf(tipo);
        } catch (IllegalArgumentException e) {
            throw new EnumException("Tipo de contato inválido!");
        }
    }

}
