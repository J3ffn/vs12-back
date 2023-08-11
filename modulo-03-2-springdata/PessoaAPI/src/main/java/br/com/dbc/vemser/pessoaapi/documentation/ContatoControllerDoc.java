package br.com.dbc.vemser.pessoaapi.documentation;

import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.ContatoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.ContatoOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

public interface ContatoControllerDoc {

    @Operation(summary = "Listar contatos.", description = "Lista todas os contatos do banco.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @GetMapping
    ResponseEntity<List<ContatoOutputDTO>> list();

    @Operation(summary = "Busca contatos de uma pessoa pelo seu ID.", description = "Faz uma busca no banco de todos os contatos relacionados a pessoa com o ID desejado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna contatos de uma pessoa específica."),
                    @ApiResponse(responseCode = "400", description = "Não foi encontrado."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @GetMapping("/pessoa/{idPessoa}")
    List<ContatoOutputDTO> contatosByIdPessoa(@Positive @PathVariable("idPessoa") Long idPessoa);

    @Operation(summary = "Criar um contato.", description = "Cadastra um contato ao banco de dados.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna informações do contato criada."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível criar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @PostMapping
    ResponseEntity<ContatoOutputDTO> create(@Valid @RequestBody ContatoInputDTO contato) throws EnumException;

    @Operation(summary = "Atualizar informações de um contato", description = "Altera campos de informações de um contato.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna informações de contato atualizado."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @PutMapping("/{idContato}")
    ResponseEntity<ContatoOutputDTO> update(@Positive @PathVariable("idContato") Long id,
                                            @Valid @RequestBody ContatoInputDTO contatoAtualizar) throws RegraDeNegocioException, EnumException;

    @Operation(summary = "Deletar um contato.", description = "Deleta um contato do banco de dados.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Não possui retorno."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @DeleteMapping("/{idContato}")
    ResponseEntity<Void> delete(@Positive @PathVariable("idContato") Long id) throws RegraDeNegocioException;

}
