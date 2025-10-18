package com.banque.courant.rest;

import com.banque.courant.ejb.CompteCourantService;
import com.banque.courant.entity.CompteCourant;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/comptecourant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompteCourantRest {

    @Inject
    private CompteCourantService service;

    @GET
    @Path("/all")
    public List<CompteCourant> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public CompteCourant getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public CompteCourant create(CompteCourant compte) { return service.create(compte); }

    @POST
    @Path("/update/{id}")
    public CompteCourant update(CompteCourant compte) { return service.update(compte); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
