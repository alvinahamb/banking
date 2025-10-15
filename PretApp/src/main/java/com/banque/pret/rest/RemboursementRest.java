package com.banque.pret.rest;

import com.banque.pret.ejb.RemboursementService;
import com.banque.pret.entity.Remboursement;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/remboursement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RemboursementRest {

    @Inject
    private RemboursementService service;

    @GET
    @Path("/all")
    public List<Remboursement> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public Remboursement getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public Remboursement create(Remboursement r) { return service.create(r); }

    @PUT
    @Path("/update/{id}")
    public Remboursement update(Remboursement r) { return service.update(r); }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
