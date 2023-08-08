package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.PessoaInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.PessoaOutputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    private final EmailService emailService;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, ObjectMapper objectMapper, EmailService emailService) {
        this.pessoaRepository = pessoaRepository;
        this.objectMapper = objectMapper;
        this.emailService = emailService;
    }

    public PessoaOutputDTO create(PessoaInputDTO pessoaNova) throws MessagingException {
        Pessoa pessoa = objectMapper.convertValue(pessoaNova, Pessoa.class);
        emailService.sendSimpleCreateAccontConfirmation(pessoa);
        return objectMapper.convertValue(pessoaRepository.create(pessoa), PessoaOutputDTO.class);
    }

    public List<PessoaOutputDTO> list() {
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaOutputDTO.class))
                .toList();
    }

    public PessoaOutputDTO update(Integer id, PessoaInputDTO pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        return objectMapper.convertValue(pessoaRecuperada, PessoaOutputDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<PessoaOutputDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaOutputDTO.class))
                .toList();
    }

    private Pessoa getPessoa(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    }

    public PessoaOutputDTO findById(Integer idBuscado) throws RegraDeNegocioException {
        return objectMapper.convertValue(getPessoa(idBuscado), PessoaOutputDTO.class);
    }
}
