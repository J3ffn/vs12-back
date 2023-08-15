package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.PessoaInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.*;
import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.utils.TapedQuery;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final ObjectMapper objectMapper;

    private final EmailService emailService;

    public PessoaOutputDTO create(PessoaInputDTO pessoaNova) throws MessagingException {
        Pessoa pessoaConvertida = objectMapper.convertValue(pessoaNova, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.save(pessoaConvertida);

//        emailService.sendTemplateMailCreateAccontConfirmation(pessoaCriada);

        return objectMapper.convertValue(pessoaCriada, PessoaOutputDTO.class);
    }

    public List<PessoaOutputDTO> findAll() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaOutputDTO.class))
                .toList();
    }

    public PessoaOutputDTO update(Long id, PessoaInputDTO pessoaAtualizar) throws RegraDeNegocioException, MessagingException {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());

//        emailService.sendTemplateMailUpdateAccount(pessoaRecuperada);

        pessoaRepository.save(pessoaRecuperada);

        return objectMapper.convertValue(pessoaRecuperada, PessoaOutputDTO.class);
    }

    public void delete(Long id) throws RegraDeNegocioException, MessagingException {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
//        emailService.sendTemplateMailDeleteAccount(pessoaRecuperada);
    }

    public List<PessoaOutputDTO> listByName(String nome) {
        return pessoaRepository.findByNome(nome)
                .stream()
                .map(this::PessoaToDTO)
                .toList();
    }

    public PessoaOutputDTO findById(Long idBuscado) throws RegraDeNegocioException {
        return objectMapper.convertValue(getPessoa(idBuscado), PessoaOutputDTO.class);
    }

    public List<PessoaOutputEnderecosDTO> findAllWithEnderecos(Long idPessoa) throws RegraDeNegocioException {

        return pessoaRepository.findAllComOptional(idPessoa)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaOutputEnderecosDTO.class)).toList();
    }

    public List<PessoaOutputContatoDTO> findPessoasWithContatos(Long idPessoa) throws RegraDeNegocioException {

        return pessoaRepository.findAllComOptional(idPessoa)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaOutputContatoDTO.class))
                .toList();
    }

    public List<PessoaOutputPetsDTO> findPessoasWithPets(Long idPessoa) throws RegraDeNegocioException {

        return pessoaRepository.findAllComOptional(idPessoa)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaOutputPetsDTO.class))
                .toList();

    }

    private Pessoa getPessoa(Long id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não encontrou!"));
    }

    private PessoaOutputDTO PessoaToDTO(Pessoa pessoa) {
        return objectMapper.convertValue(pessoa, PessoaOutputDTO.class);
    }

}
