package br.fiap.api_security.controller;

import br.fiap.api_security.dto.AuthDTO;
import br.fiap.api_security.dto.RegisterDTO;
import br.fiap.api_security.entity.Usuario;
import br.fiap.api_security.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          UsuarioRepository usuarioRepository){
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO){
        // Gera um token para esse usuario e senha
        var userPwd = new UsernamePasswordAuthenticationToken(
                authDTO.login(),
                authDTO.senha()
        );
        // Autentica o token
        var auth = this.authenticationManager.authenticate(userPwd);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        if (usuarioRepository.findByLogin(registerDTO.login()) != null){
            return ResponseEntity.badRequest().build();
        }
        String senhaCriptografada = new BCryptPasswordEncoder()
                .encode(registerDTO.senha());
        Usuario novoUsuario = new Usuario(
                registerDTO.login(),
                senhaCriptografada,
                registerDTO.role());

        usuarioRepository.save(novoUsuario);
        return ResponseEntity.ok().build();

    }
}
