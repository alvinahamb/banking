package com.banque.pret.rest.client;

import com.banque.pret.ejb.client.StatusClientService;
import com.banque.pret.entity.client.StatusClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/statusclient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusClientRest {

    @Inject
    private StatusClientService service;

    @GET
    @Path("/all")
    public List<StatusClient> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public StatusClient getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public StatusClient create(StatusClient s) { return service.create(s); }

    @POST
    @Path("/update/{id}")
    public StatusClient update(StatusClient s) { return service.update(s); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
