package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.PetInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.PetOutputDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.model.entity.Pet;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class PetService {

    private final PetRepository petRepository;

    private final PessoaService pessoaService;

    private final ObjectMapper objectMapper;

    public PetOutputDTO create(Long idPessoa, PetInputDTO petCreate) {
        petCreate.setIdPessoa(idPessoa);

        Pet petNovo = objectMapper.convertValue(petCreate, Pet.class);
        petRepository.save(petNovo);
        return objectMapper.convertValue(petNovo, PetOutputDTO.class);
    }

    public PetOutputDTO update(Long idPet, PetInputDTO petAtualizacao) throws RegraDeNegocioException {
        if (!petRepository.existsById(idPet)) {
            throw new RegraDeNegocioException("Pet inexistente!");
        }

        Pet petModificado = petRepository.getById(idPet);
        petModificado.setNome(petAtualizacao.getNome());
        petModificado.setTipo(petAtualizacao.getTipo());

        if (petAtualizacao.getIdPessoa() != null) {
            Pessoa pessoa = objectMapper.convertValue(pessoaService.findById(petAtualizacao.getIdPessoa()), Pessoa.class);
            petModificado.setPessoa(pessoa);
        }

        petRepository.save(petModificado);
        return objectMapper.convertValue(petModificado, PetOutputDTO.class);
    }

    public void delete(Long idPet) {
        petRepository.deleteById(idPet);
    }

    public PetOutputDTO findById(Long idPet) {
        Pet petBuscado = petRepository.getById(idPet);
        return objectMapper.convertValue(petBuscado, PetOutputDTO.class);
    }

    public List<PetOutputDTO> findAll() {
        return petRepository.findAll().stream().map(pet -> objectMapper.convertValue(pet, PetOutputDTO.class)).toList();
    }
}
