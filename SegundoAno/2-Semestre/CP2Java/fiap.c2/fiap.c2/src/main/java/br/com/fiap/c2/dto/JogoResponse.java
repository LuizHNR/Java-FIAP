package br.com.fiap.c2.dto;

import org.springframework.hateoas.Link;

public record JogoResponse(Long id, String nome, Link link) {
}
