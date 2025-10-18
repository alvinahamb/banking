package com.banque.pret.rest.client;

import com.banque.pret.ejb.client.ClientsService;
import com.banque.pret.entity.client.Clients;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientsRest {

    @Inject
    private ClientsService service;

    @GET
    @Path("/all")
    public List<Clients> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public Clients getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public Clients create(Clients c) { return service.create(c); }

    @POST
    @Path("/update/{id}")
    public Clients update(Clients c) { return service.update(c); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
