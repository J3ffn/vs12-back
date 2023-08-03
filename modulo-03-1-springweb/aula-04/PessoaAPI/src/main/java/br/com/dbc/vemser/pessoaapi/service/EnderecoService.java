package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco getEnderecoById(Integer idEndereco) throws Exception {
        return list().stream()
                .filter(endereco -> endereco.getIdEndereco() == idEndereco)
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
    }

    public List<Endereco> getEnderecosByIdPessoa(Integer idPessoa) {
        return list().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .toList();
    }

    public Endereco create(Integer idPessoa, Endereco endereco) {
        endereco.setIdPessoa(idPessoa);
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoModificado) throws Exception {
        Endereco enderecoResgatado = getEnderecoById(idEndereco);

        enderecoResgatado.setIdPessoa(enderecoModificado.getIdPessoa());
        enderecoResgatado.setCep(enderecoModificado.getCep());
        enderecoResgatado.setCidade(enderecoModificado.getCidade());
        enderecoResgatado.setEstado(enderecoModificado.getEstado());
        enderecoResgatado.setComplemento(enderecoModificado.getComplemento());
        enderecoResgatado.setLogradouro(enderecoModificado.getLogradouro());
        enderecoResgatado.setNumero(enderecoModificado.getNumero());
        enderecoResgatado.setPais(enderecoModificado.getPais());
        enderecoResgatado.setTipo(enderecoModificado.getTipo());

        return enderecoResgatado;
    }

    public void delete(Integer idEndereco) throws Exception {
        Endereco endereco = getEnderecoById(idEndereco);
        enderecoRepository.delete(endereco);
    }

}
