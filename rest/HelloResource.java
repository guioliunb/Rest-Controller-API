package br.com.bb.crv.bootstrap.integration;


import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.opentracing.Traced;

import br.com.bb.crv.bootstrap.services.HelloService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
@Traced
public class HelloResource {

        @Inject
        HelloService service;

        @GET
    @Operation(summary = "Hello",
            description = "Retorna string Hello")
    @APIResponse(
            responseCode = "200",
            description = "Hello",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = HelloService.class, type = SchemaType.STRING))})
    public Response respondeHello() throws Exception  {
        return Response.status(Response.Status.OK).entity(service.respondeHello()).build();
    } 

    @GET
    @Path("/{nome}")
    @Operation(summary = "Hello",
            description = "Retorna string Hello")
    @APIResponse(
            responseCode = "200",
            description = "Hello",
            content = { @Content(mediaType = "text/plain",
                    schema = @Schema(implementation = HelloService.class, type = SchemaType.STRING))})
    public Response respondeHello(final @PathParam("nome") String nome) throws Exception  {
        return Response.status(Response.Status.OK).entity(service.respondeComNome(nome)).build();
    } 

    @GET
    @Path("/{nome}/horario")
    @Operation(summary = "Hello",
            description = "Retorna string Hello")
    @APIResponse(
            responseCode = "200",
            description = "Hello",
            content = { @Content(mediaType = "text/plain",
                    schema = @Schema(implementation = HelloService.class, type = SchemaType.STRING))})
    public Response respondeComData(final @PathParam("nome") String nome) throws Exception  {
        return Response.status(Response.Status.OK).entity(service.respondeComData(nome)).build();
    } 

       
    
}

