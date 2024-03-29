package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.model.dto.input.ContatoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.ContatoOutputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Contato;
import br.com.dbc.vemser.pessoaapi.model.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final PessoaService pessoaService;

    private final ObjectMapper objectMapper;

    public ContatoOutputDTO create(Long idPessoa, ContatoInputDTO contato) throws EnumException, RegraDeNegocioException {

        Contato contatoConvertido = objectMapper.convertValue(contato, Contato.class);
        contatoConvertido.setPessoa(objectMapper.convertValue(pessoaService.findById(idPessoa), Pessoa.class));

        contatoConvertido = contatoRepository.save(contatoConvertido);

        ContatoOutputDTO contatoOutputDTO = objectMapper.convertValue(contatoConvertido, ContatoOutputDTO.class);
        contatoOutputDTO.setIdPessoa(contatoConvertido.getPessoa().getIdPessoa());

        return contatoOutputDTO;
    }

    public List<ContatoOutputDTO> findAll() {
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoOutputDTO.class))
                .toList();
    }

    public ContatoOutputDTO update(Long idContato, ContatoInputDTO contatoAtualizar) throws RegraDeNegocioException, EnumException {

        TipoContato tipoContato = this.checarEnum(contatoAtualizar.getTipoContato());

        Contato contatoRecuperado = this.getContato(idContato);

        contatoRecuperado.setIdContato(idContato);
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoContato(tipoContato);
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());

        contatoRepository.save(contatoRecuperado);

        return objectMapper.convertValue(contatoRecuperado, ContatoOutputDTO.class);
    }

    public void delete(Long id) throws RegraDeNegocioException {
        Contato contatoRecuperada = getContato(id);
        contatoRepository.delete(contatoRecuperada);
    }

    public List<ContatoOutputDTO> getContatosByIdUsuario(Long idPessoa) {
        return findAll().stream().filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .map(contato -> objectMapper.convertValue(contato, ContatoOutputDTO.class))
                .toList();
    }

    private Contato getContato(Long id) throws RegraDeNegocioException {
        return contatoRepository.findById(id)
                .stream()
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
