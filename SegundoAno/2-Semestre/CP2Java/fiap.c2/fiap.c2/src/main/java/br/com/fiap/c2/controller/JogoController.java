package br.com.fiap.c2.controller;

import br.com.fiap.c2.dto.JogoRequest;
import br.com.fiap.c2.dto.JogoResponse;
import br.com.fiap.c2.model.Jogo;
import br.com.fiap.c2.repository.JogoRepository;
import br.com.fiap.c2.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/jogos", produces = {"application/json"})
@Tag(name = "api-jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private JogoService jogoService;

    @Operation(summary = "Cria um novo jogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogo cadastrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Jogo.class))}),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos",
                    content = @Content(schema = @Schema()))
    })

    @PostMapping
    public ResponseEntity<Jogo> createJogo(@Valid @RequestBody JogoRequest jogo) {
        Jogo jogoSalvo = jogoRepository.save(jogoService.requestToJogo(jogo));
        return new ResponseEntity<>(jogoSalvo, HttpStatus.CREATED);
    }


    @Operation(summary = "Retorna uma lista de jogos")
    @GetMapping
    public ResponseEntity<Page<JogoResponse>> readJogos(@RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("nome").ascending());
        return new ResponseEntity<>(jogoService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Retorna um jogo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogo encontrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = JogoResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Nenhum jogo encontrado",
                    content = @Content(schema = @Schema()))
    })

    @GetMapping("/{id}")
    public ResponseEntity<JogoResponse> readJogo(@PathVariable Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        if (jogo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jogoService.jogoToResponse(jogo.get(), false), HttpStatus.OK);
    }

    @Operation(summary = "Atualiza um jogo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogo encontrado e atualizado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Jogo.class))}),
            @ApiResponse(responseCode = "400", description = "Nenhum jogo encontrado para atualizar",
                    content = @Content(schema = @Schema()))
    })

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> updateJogo(@PathVariable Long id, @RequestBody Jogo jogo) {
        Optional<Jogo> jogoExistente = jogoRepository.findById(id);
        if (jogoExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        jogo.setId(jogoExistente.get().getId());
        Jogo jogoAtualizado = jogoRepository.save(jogo);
        return new ResponseEntity<>(jogoAtualizado, HttpStatus.CREATED);
    }

    @Operation(summary = "Exclui um jogo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Nenhum jogo encontrado para excluir",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "204", description = "Jogo excluído com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJogo(@PathVariable Long id) {
        Optional<Jogo> jogoExistente = jogoRepository.findById(id);
        if (jogoExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        jogoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
