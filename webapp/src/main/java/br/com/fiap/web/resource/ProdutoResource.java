package br.com.fiap.web.resource;

import br.com.fiap.web.dto.ProdutoRequestDto;
import br.com.fiap.web.model.Produto;
import br.com.fiap.web.service.ProdutoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/produtos")
public class ProdutoResource {

    private ProdutoService service = new ProdutoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProdutoRequestDto> listar(){
        return service.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoRequestDto buscar(@PathParam("id") int codigo){
        return service.buscarPorId(codigo);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(ProdutoRequestDto produto, @Context UriInfo uriInfo){
        service.cadastrar(produto);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(produto.getCodigo()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterar(ProdutoRequestDto produto, @PathParam("id") int id){
        if(id == produto.getCodigo()){
            service.atualizar(produto);
            return Response.ok().build();}
        else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") int id){
        service.deletar(id);
    }





}
