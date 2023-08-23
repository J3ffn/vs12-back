package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.model.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.model.entity.CargoEntity;
import br.com.dbc.vemser.pessoaapi.model.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.repository.CargoRepository;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final CargoRepository cargoRepository;

    private String generateToken(String senha) {
        return passwordEncoder.encode(senha);
    }

    public UsuarioEntity save(LoginDTO loginDTO, String role) throws RegraDeNegocioException {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setLogin(loginDTO.getLogin());
        String senhaCriptografada = generateToken(loginDTO.getSenha());

        CargoEntity cargo = cargoRepository.findCargoEntityByNome(role);
        if (cargo == null) {
            throw new RegraDeNegocioException("Cargo não existe");
        }

        usuario.setSenha(senhaCriptografada);
        usuario.setCargos(new HashSet<>());
        usuario.getCargos().add(cargo);

//        cargo.setUsuarios(new HashSet<>());
//        cargo.getUsuarios().add(usuario);

        usuarioRepository.save(usuario);
        return usuario;
    }

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Integer getIdLoggedUser() {
        Integer findUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserId;
    }

    public UsuarioEntity findById(Integer idUsuario) throws RegraDeNegocioException {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RegraDeNegocioException("Usuário não encontrado!"));
    }

    public Optional<UsuarioEntity> findByLogin(String username) {
        return usuarioRepository.findByLogin(username);
    }
}