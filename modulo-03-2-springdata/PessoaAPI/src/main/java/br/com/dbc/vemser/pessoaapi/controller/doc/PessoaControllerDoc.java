package br.com.dbc.vemser.pessoaapi.controller.doc;

import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.PessoaInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.PessoaOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;


public interface PessoaControllerDoc {

    @Operation(summary = "Listar pessoas.", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    List<PessoaOutputDTO> list();

    @Operation(summary = "Listar pessoas pelo nome.", description = "Lista todas as pessoas do banco por um nome específico")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna uma lista de pessoas."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível buscar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @GetMapping("/byname")
    List<PessoaOutputDTO> listByName(@NotBlank @RequestParam("nome") String nome);

    @Operation(summary = "Criar uma pessoa.", description = "Cadastra uma pessoa ao banco de dados.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna informações da pessoas criada."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível criar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @PostMapping
    PessoaOutputDTO create(@Valid @RequestBody PessoaInputDTO pessoa) throws Exception;

    @Operation(summary = "Atualizar informações de uma pessoa.", description = "Altera campos de informações de uma pessoa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna informações da pessoas atualizada."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @PutMapping("/{idPessoa}")
    PessoaOutputDTO update(@Positive @PathVariable("idPessoa") Integer id,
                           @Valid @RequestBody PessoaInputDTO pessoaAtualizar) throws RegraDeNegocioException, MessagingException;

    @Operation(summary = "Deletar uma pessoa.", description = "Deleta uma pessoa do banco de dados.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Não possui retorno."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @DeleteMapping("/{idPessoa}")
    void delete(@Positive @PathVariable("idPessoa") Integer id) throws RegraDeNegocioException, MessagingException;

    @Operation(summary = "Buscar pessoa pelo ID.", description = "Busca uma pessoa pelo seu ID.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna informações da pessoas atualizada."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @GetMapping("/{idPessoa}")
    PessoaOutputDTO findById(Integer id) throws RegraDeNegocioException;

    @Operation(summary = "Verificar ambiente do servidor.", description = "Informa em qual ambiente o servidor está setado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna informações da pessoas atualizada."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @GetMapping("/ambiente")
    String getAmbiente();

}