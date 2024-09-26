package br.com.fiap.web.resource;

import br.com.fiap.web.model.Produto;
import br.com.fiap.web.service.ProdutoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/produtos")
public class ProdutoResource {

    private ProdutoService service = new ProdutoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar(){
        return service.listar();
    }
}
