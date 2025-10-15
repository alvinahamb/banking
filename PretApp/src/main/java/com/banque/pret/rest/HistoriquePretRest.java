package com.banque.pret.rest;

import com.banque.pret.ejb.HistoriquePretService;
import com.banque.pret.entity.HistoriquePret;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/historiquepret")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoriquePretRest {

    @Inject
    private HistoriquePretService service;

    @GET
    @Path("/all")
    public List<HistoriquePret> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public HistoriquePret getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public HistoriquePret create(HistoriquePret h) { return service.create(h); }

    @PUT
    @Path("/update/{id}")
    public HistoriquePret update(HistoriquePret h) { return service.update(h); }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
