package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.EnderecoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.EnderecoOutputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.model.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;


    public List<EnderecoOutputDTO> findAll() {
        return enderecoRepository.findAll().stream().map(endereco -> objectMapper.convertValue(endereco, EnderecoOutputDTO.class)).toList();
    }

    public EnderecoOutputDTO create(Long idPessoa, EnderecoInputDTO enderecoNovo) throws Exception {

        checarEnum(enderecoNovo.getTipoEndereco());

        Pessoa pessoaPorId = pessoaRepository.getById(idPessoa);

        Endereco endereco = objectMapper.convertValue(enderecoNovo, Endereco.class);

//        pessoaPorId.setEnderecos(new HashSet<>());
        pessoaPorId.getEnderecos().add(endereco);

//        endereco.setPessoas(new HashSet<>());
        endereco.getPessoas().add(pessoaPorId);

        return objectMapper.convertValue(enderecoRepository.save(endereco), EnderecoOutputDTO.class);
    }

    public EnderecoOutputDTO update(Long idEndereco, EnderecoInputDTO enderecoModificado) throws RegraDeNegocioException, EnumException {
        TipoEndereco tipoEndereco = this.checarEnum(enderecoModificado.getTipoEndereco());

        Endereco enderecoResgatado = enderecoRepository.findById(idEndereco).stream().findFirst().orElseThrow(() -> new RegraDeNegocioException("Não encontrado!"));

        enderecoResgatado.setCep(enderecoModificado.getCep());
        enderecoResgatado.setCidade(enderecoModificado.getCidade());
        enderecoResgatado.setEstado(enderecoModificado.getEstado());
        enderecoResgatado.setComplemento(enderecoModificado.getComplemento());
        enderecoResgatado.setLogradouro(enderecoModificado.getLogradouro());
        enderecoResgatado.setNumero(enderecoModificado.getNumero().longValue());
        enderecoResgatado.setPais(enderecoModificado.getPais());
        enderecoResgatado.setTipoEndereco(tipoEndereco);

        enderecoRepository.save(enderecoResgatado);

        return objectMapper.convertValue(enderecoResgatado, EnderecoOutputDTO.class);
    }

    public void delete(Long idEndereco) throws Exception {
        Endereco endereco = objectMapper.convertValue(getEnderecoById(idEndereco), Endereco.class);
        enderecoRepository.delete(endereco);
    }

    public EnderecoOutputDTO getEnderecoById(Long idEndereco) throws RegraDeNegocioException {
        Endereco endereco = enderecoRepository.findById(idEndereco).stream().findFirst().orElseThrow(() -> new RegraDeNegocioException("Não encontrado!"));
        return objectMapper.convertValue(endereco, EnderecoOutputDTO.class);
    }

    public Set<EnderecoOutputDTO> findEnderecosByIdPessoa(Long idPessoa) {
//        return enderecoRepository.findByIdWithEnderecos(idPessoa).stream().map(endereco -> objectMapper.convertValue(endereco, EnderecoOutputDTO.class)).collect(Collectors.toSet());
        return new HashSet<>(findAll());
    }

    private TipoEndereco checarEnum(String tipo) throws EnumException {
        try {
            return TipoEndereco.valueOf(tipo);
        } catch (IllegalArgumentException e) {
            throw new EnumException("Tipo de contato inválido!");
        }
    }

}
