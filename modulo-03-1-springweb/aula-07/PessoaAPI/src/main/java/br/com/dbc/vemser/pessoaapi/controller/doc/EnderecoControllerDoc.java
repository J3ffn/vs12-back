package br.com.dbc.vemser.pessoaapi.controller.doc;

import br.com.dbc.vemser.pessoaapi.exception.EnumException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.input.EnderecoInputDTO;
import br.com.dbc.vemser.pessoaapi.model.dto.output.EnderecoOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

public interface EnderecoControllerDoc {

    @Operation(summary = "Listar Enderecos.", description = "Lista todas os enderecos do banco.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de enderecos."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @GetMapping
    ResponseEntity<List<EnderecoOutputDTO>> list();

    @Operation(summary = "Busca um endereço pelo ID.", description = "Procura um endereço com o ID passado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna informações de contato atualizado."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @GetMapping("/{idEndereco}")
    ResponseEntity<EnderecoOutputDTO> getEnderecoById(@Positive @PathVariable Integer idEndereco) throws Exception;

    @Operation(summary = "Busca enderecos de uma pessoa pelo seu ID.", description = "Faz uma busca no banco de todos os contatos relacionados a pessoa com o ID desejado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna enderecos de uma pessoa específica."),
                    @ApiResponse(responseCode = "400", description = "Não foi encontrado."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @GetMapping("/{idPessoa}/pessoa")
    ResponseEntity<List<EnderecoOutputDTO>> getEnderecosByIdPessoa(@Positive @PathVariable Integer idPessoa);

    @Operation(summary = "Criar um endereco.", description = "Cadastra um endereco ao banco de dados vinculando ao ID passado como parâmetro.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna informações do endereco criada."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível criar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @PostMapping("/{idPessoa}")
    ResponseEntity<EnderecoOutputDTO> create(@Positive @PathVariable Integer idPessoa, @Valid @RequestBody EnderecoInputDTO endereco) throws Exception;

    @Operation(summary = "Atualizar informações de um endereco", description = "Altera campos de informações de um endereco.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna informações de endereco atualizado."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @PutMapping("/{idEndereco}")
    ResponseEntity<EnderecoOutputDTO> update(@Positive @PathVariable Integer idEndereco, @Valid @RequestBody EnderecoInputDTO endereco) throws RegraDeNegocioException, EnumException;

    @Operation(summary = "Deletar um endereco.", description = "Deleta um endereco do banco de dados.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Não possui retorno."),
                    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso."),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção.")
            }
    )
    @DeleteMapping("/{idEndereco}")
    void delete(@Positive @PathVariable Integer idEndereco) throws Exception;

}
