package br.com.fiap.c2.service;

import br.com.fiap.c2.controller.UsuarioController;
import br.com.fiap.c2.dto.UsuarioRequest;
import br.com.fiap.c2.dto.UsuarioResponse;
import br.com.fiap.c2.model.Jogo;
import br.com.fiap.c2.model.Usuario;
import br.com.fiap.c2.repository.JogoRepository;
import br.com.fiap.c2.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final JogoRepository jogoRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, JogoRepository jogoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.jogoRepository = jogoRepository;
    }

    public Usuario requestToUsuario(UsuarioRequest request) {
        List<Jogo> jogos = new ArrayList<>();
        if (request.getCarrinho() != null && !request.getCarrinho().isEmpty()) {
            jogos = jogoRepository.findAllById(request.getCarrinho());
        }

        return new Usuario(
                null,
                request.getNome(),
                request.getIdade(),
                request.getEmail(),
                request.getSenha(),
                jogos
        );
    }

    public UsuarioResponse usuarioToResponse(Usuario usuario, boolean self) {
        Link link = self
                ? linkTo(methodOn(UsuarioController.class).readUsuario(usuario.getId())).withSelfRel()
                : linkTo(methodOn(UsuarioController.class).readUsuarios(0)).withRel("Lista de Usuarios");

        return new UsuarioResponse(usuario.getId(), usuario.getNome(), link);
    }

    public List<UsuarioResponse> usuariosToResponse(List<Usuario> usuarios) {
        List<UsuarioResponse> usuarioResponseList = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioResponseList.add(usuarioToResponse(usuario, true));
        }
        return usuarioResponseList;
    }

    public Page<UsuarioResponse> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable)
                .map(usuario -> usuarioToResponse(usuario, true));
    }
}
