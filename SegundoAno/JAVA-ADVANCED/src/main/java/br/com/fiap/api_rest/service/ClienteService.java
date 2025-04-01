package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.controller.ClienteController;
import br.com.fiap.api_rest.dto.ClienteRequest;
import br.com.fiap.api_rest.dto.ClienteResponse;
import br.com.fiap.api_rest.model.Cliente;
import br.com.fiap.api_rest.repository.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
//    @Autowired
//    ClienteRepository clienteRepository;

    public Cliente requestToCliente(ClienteRequest clienteRequest) {
        return new Cliente(null,
                clienteRequest.getNome(),
                clienteRequest.getIdade(),
                clienteRequest.getEmail(),
                clienteRequest.getSenha(),
                clienteRequest.getCpf(),
                clienteRequest.getCategoria());
    }

    public ClienteResponse clienteToResponse(Cliente cliente, boolean self) {
        Link link;
        if (self) {
            link = linkTo(
                    methodOn(
                            ClienteController.class
                    ).readCliente(cliente.getId())
            ).withSelfRel();
        } else {
            link = linkTo(
                    methodOn(
                            ClienteController.class
                    ).readClientes(0)
            ).withRel("Lista de Clientes");
        }
        return new ClienteResponse(cliente.getId(), cliente.getNome(), link);
    }

    public List<ClienteResponse> clientesToResponse(List<Cliente> clientes) {
        List<ClienteResponse> clientesResponse = new ArrayList<>();
        for (Cliente cliente : clientes) {
            clientesResponse.add(clienteToResponse(cliente, true));
        }
        return clientesResponse;
        // return clientes.stream().map(this::clienteToResponse).collect(Collectors.toList());
    }

    public Page<ClienteResponse> findAll(Pageable pageable) {
        // busca os clientes de acordo com a configuração do pageable,
        // converte para response e retorna como um Page<ClienteResponse>
        return clienteRepository.findAll(pageable)
                .map(cliente -> clienteToResponse(cliente, true));
        //return clienteRepository.findAll(pageable).map(this::clienteToResponse);
    }
}
