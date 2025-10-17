package com.banque.pret.rest.client;

import com.banque.pret.ejb.client.TrancheRevenuService;
import com.banque.pret.entity.client.TrancheRevenu;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/trancherevenu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TrancheRevenuRest {

    @Inject
    private TrancheRevenuService service;

    @GET
    @Path("/all")
    public List<TrancheRevenu> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public TrancheRevenu getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public TrancheRevenu create(TrancheRevenu t) { return service.create(t); }

    @GET
    @Path("/update/{id}")
    public TrancheRevenu update(TrancheRevenu t) { return service.update(t); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
