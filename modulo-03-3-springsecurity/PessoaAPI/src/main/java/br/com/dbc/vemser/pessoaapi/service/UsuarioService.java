package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.model.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private String generateToken(String senha) {
        return passwordEncoder.encode(senha);
    }

    public LoginDTO save(LoginDTO loginDTO) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setLogin(loginDTO.getLogin());
        String senhaCriptografada = generateToken(loginDTO.getSenha());

        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);
        return loginDTO;
    }

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Optional<UsuarioEntity> findByLogin(String username) {
        return usuarioRepository.findByLogin(username);
    }
}