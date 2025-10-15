package com.banque.pret.rest;

import com.banque.pret.ejb.ModeDePaiementService;
import com.banque.pret.entity.ModeDePaiement;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/ModeDePaiement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ModeDePaiementRest {

    @Inject
    private ModeDePaiementService service;

    @GET
    @Path("/all")
    public List<ModeDePaiement> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public ModeDePaiement getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public ModeDePaiement create(ModeDePaiement type) { return service.create(type); }

    @PUT
    @Path("/update/{id}")
    public ModeDePaiement update(ModeDePaiement type) { return service.update(type); }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
