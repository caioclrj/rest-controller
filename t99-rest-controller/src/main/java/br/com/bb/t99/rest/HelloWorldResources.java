package br.com.bb.t99.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import br.com.bb.t99.services.HoraService;
import lombok.RequiredArgsConstructor;

@Path("/hello")
@RequestScoped
@RequiredArgsConstructor
public class HelloWorldResources {

    private final HoraService horaService;
    private static final Logger log = Logger.getLogger(HelloWorldResources.class);
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {

        log.info("Hello simples.");
        return Response.status(Response.Status.OK).entity("Hello!").build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{nome}")
    public Response helloNome(@PathParam("nome") String nome) {

        log.info("Hello nomeado. \tNome: " + nome);
        return Response.status(Response.Status.OK).entity(
            "Hello, " + nome + "!").build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{nome}/horario")
    public Response helloNomeDataHora(@PathParam("nome") String nome) {

        String hora = horaService.definirHora();

        log.info("Hello nomeado temporal. \tNome: " + nome 
        + "\tHora: " + hora);
        return Response.status(Response.Status.OK).entity(
            "Hello " + nome + "! Agora são " + hora +
            ", não se esqueça!").build();
    }
}
