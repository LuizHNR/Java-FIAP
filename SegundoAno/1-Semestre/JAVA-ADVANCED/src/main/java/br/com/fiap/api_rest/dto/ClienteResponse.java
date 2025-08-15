package br.com.fiap.api_rest.dto;

import org.springframework.hateoas.Link;

public record ClienteResponse(Long id, String nome, Link link) {
}
