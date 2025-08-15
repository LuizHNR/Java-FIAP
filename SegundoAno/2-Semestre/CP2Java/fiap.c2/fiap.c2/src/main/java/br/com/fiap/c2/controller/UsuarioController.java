package br.com.fiap.c2.controller;

import br.com.fiap.c2.dto.UsuarioRequest;
import br.com.fiap.c2.dto.UsuarioResponse;
import br.com.fiap.c2.model.Usuario;
import br.com.fiap.c2.repository.UsuarioRepository;
import br.com.fiap.c2.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.Optional;

@RestController
@RequestMapping(value ="/usuarios", produces = {"application/json"})
@Tag(name = "api-usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;


    @Operation(summary = "Cria um novo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario cadastrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody UsuarioRequest usuario) {
        Usuario usuarioSalvo = usuarioRepository.save(usuarioService.requestToUsuario(usuario));
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
    }

    @Operation(summary = "Retorna uma lista de usuarios")
    @GetMapping
    public ResponseEntity<Page<UsuarioResponse>> readUsuarios(@RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 2, (Sort.by("nome").ascending()));
        return new ResponseEntity<>(usuarioService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Retorna um usuario por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Nenhum usuario encontrado",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> readUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioService.usuarioToResponse(usuario.get(), false), HttpStatus.OK);
    }

    @Operation(summary = "Atualiza um usuario existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario encontrado e atualizado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400", description = "Nenhum usuario encontrado para atualizar",
                    content = @Content(schema = @Schema()))
    })
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,
                                                 @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        usuario.setId(usuarioExistente.get().getId());
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.CREATED);
    }

    @Operation(summary = "Exclui um usuario por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Nenhum usuario encontrado para excluir",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "204", description = "Usuario excluído com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        usuarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}