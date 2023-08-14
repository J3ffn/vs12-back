package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.PetInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.PetOutputDTO;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RequiredArgsConstructor

@Validated
@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    @GetMapping
    public List<PetOutputDTO> findAll() {
        return petService.findAll();
    }

    @PostMapping("/pessoa/{idPessoa}")
    public PetOutputDTO create(@Positive @PathVariable Long idPessoa, PetInputDTO petCreate) {
        return petService.create(idPessoa, petCreate);
    }

    @PutMapping("/{idPet}")
    public PetOutputDTO update(@Positive @PathVariable Long idPet,
                               @Valid @RequestBody PetInputDTO petAtualizacao) throws RegraDeNegocioException {
        return petService.update(idPet, petAtualizacao);
    }

    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable Long idPet) {
        petService.delete(idPet);
    }

    @GetMapping("/{idPet}")
    public PetOutputDTO findById(@PathVariable Long idPet) {
        return petService.findById(idPet);
    }

}
