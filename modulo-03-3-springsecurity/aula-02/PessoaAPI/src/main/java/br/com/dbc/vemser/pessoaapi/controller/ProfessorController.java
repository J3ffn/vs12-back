package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.entity.ProfessorPK;
import br.com.dbc.vemser.pessoaapi.model.dto.input.ProfessorInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.ProfessorOutputDTO;
import br.com.dbc.vemser.pessoaapi.service.ProfessorService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorOutputDTO> save(@RequestBody ProfessorInputDTO professorRecebido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professorRecebido));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody ProfessorPK idProfessor) {
        professorService.delete(idProfessor);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idProfessor}")
    public ResponseEntity<List<ProfessorOutputDTO>> findById(@PathVariable Long idProfessor) throws RegraDeNegocioException {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findByIdProfessor(idProfessor));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorOutputDTO>> findAll() throws NotFoundException {
        return ResponseEntity.ok().body(professorService.findAll());
    }

}
