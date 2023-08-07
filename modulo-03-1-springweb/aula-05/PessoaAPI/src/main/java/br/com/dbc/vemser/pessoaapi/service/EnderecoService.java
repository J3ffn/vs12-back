package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.EnderecoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.model.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository, ObjectMapper objectMapper, PessoaService pessoaService) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public List<Endereco> getEnderecosByIdPessoa(Integer idPessoa) {
        return list().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .toList();
    }

    public Endereco create(Integer idPessoa, EnderecoInputDTO enderecoNovo) throws Exception {

        Pessoa pessoaPorId = pessoaService.findById(idPessoa);

        checarEnum(enderecoNovo.getTipo());

        Endereco endereco = objectMapper.convertValue(enderecoNovo, Endereco.class);

        endereco.setIdPessoa(pessoaPorId.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer idEndereco, EnderecoInputDTO enderecoModificado) throws RegraDeNegocioException, EnumException {
        Endereco enderecoResgatado = this.getEnderecoById(idEndereco);

        this.checarEnum(enderecoModificado.getTipo());

        enderecoResgatado.setIdPessoa(enderecoModificado.getIdPessoa());
        enderecoResgatado.setCep(enderecoModificado.getCep());
        enderecoResgatado.setCidade(enderecoModificado.getCidade());
        enderecoResgatado.setEstado(enderecoModificado.getEstado());
        enderecoResgatado.setComplemento(enderecoModificado.getComplemento());
        enderecoResgatado.setLogradouro(enderecoModificado.getLogradouro());
        enderecoResgatado.setNumero(enderecoModificado.getNumero());
        enderecoResgatado.setPais(enderecoModificado.getPais());
        enderecoResgatado.setTipo(TipoEndereco.valueOf(enderecoModificado.getTipo()));

        return enderecoResgatado;
    }

    public void delete(Integer idEndereco) throws Exception {
        Endereco endereco = getEnderecoById(idEndereco);
        enderecoRepository.delete(endereco);
    }

    public Endereco getEnderecoById(Integer idEndereco) throws RegraDeNegocioException {
        return list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
    }

    private void checarEnum(String tipo) throws EnumException {
        try {
            TipoEndereco.valueOf(tipo);
        } catch (IllegalArgumentException e) {
            throw new EnumException("Tipo de contato inválido!");
        }
    }

}
