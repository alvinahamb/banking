package com.banque.pret.rest;

import com.banque.pret.ejb.PretService;
import com.banque.pret.entity.Pret;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/pret")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PretRest {

    @Inject
    private PretService service;

    @GET
    @Path("/all")
    public List<Pret> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public Pret getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public Pret create(Pret pret) { return service.create(pret); }

    @POST
    @Path("/update/{id}")
    public Pret update(Pret pret) { return service.update(pret); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }

}
