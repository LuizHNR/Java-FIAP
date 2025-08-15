package br.com.fiap.c2.service;

import br.com.fiap.c2.controller.JogoController;
import br.com.fiap.c2.dto.JogoRequest;
import br.com.fiap.c2.dto.JogoResponse;
import br.com.fiap.c2.model.Jogo;
import br.com.fiap.c2.repository.JogoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public Jogo requestToJogo(JogoRequest jogoRequest) {
        return new Jogo(
                null,
                jogoRequest.getNome(),
                jogoRequest.getDataLancamento(),
                jogoRequest.getGenero());
    }

    public JogoResponse jogoToResponse(Jogo jogo, boolean self) {
        Link link;
        if (self) {
            link = linkTo(methodOn(JogoController.class).readJogo(jogo.getId()))
                    .withSelfRel();
        } else {
            link = linkTo(methodOn(JogoController.class).readJogos(0))
                    .withRel("Lista de Jogos");
        }

        return new JogoResponse(jogo.getId(), jogo.getNome(), link);
    }

    public List<JogoResponse> jogoToResponse(List<Jogo> jogos) {
        List<JogoResponse> jogoResponse = new ArrayList<>();
        for (Jogo jogo : jogos) {
            jogoResponse.add(jogoToResponse(jogo, true));
        }
        return jogoResponse;
    }

    public Page<JogoResponse> findAll(Pageable pageable) {
        return jogoRepository.findAll(pageable)
                .map(jogo -> jogoToResponse(jogo, true));
    }
}
