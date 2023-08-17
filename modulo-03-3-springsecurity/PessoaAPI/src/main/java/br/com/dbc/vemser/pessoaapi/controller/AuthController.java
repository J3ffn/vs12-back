//package br.com.dbc.vemser.pessoaapi.controller;
//
//import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
//import br.com.dbc.vemser.pessoaapi.model.entity.LoginDTO;
//import br.com.dbc.vemser.pessoaapi.model.entity.UsuarioEntity;
//import br.com.dbc.vemser.pessoaapi.security.TokenService;
//import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/auth")
//@Validated
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final UsuarioService usuarioService;
//    private final TokenService tokenService;
//
//    @PostMapping
//    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {
//        Optional<UsuarioEntity> byLoginAndSenha = usuarioService.findByLoginAndSenha(loginDTO.getLogin(), loginDTO.getSenha());
//        if (byLoginAndSenha.isPresent()) {
//            return tokenService.getToken(byLoginAndSenha.get());
//        } else {
//            throw new RegraDeNegocioException("usuário e senha inválidos");
//        }
//    }
//}