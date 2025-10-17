package com.banque.pret.rest;

import com.banque.pret.ejb.StatusPretService;
import com.banque.pret.entity.StatusPret;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/statuspret")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusPretRest {

    @Inject
    private StatusPretService service;

    @GET
    @Path("/all")
    public List<StatusPret> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public StatusPret getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public StatusPret create(StatusPret type) { return service.create(type); }

    @POST
    @Path("/update/{id}")
    public StatusPret update(StatusPret type) { return service.update(type); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }

    @GET
    @Path("/libelle/{libelle}")
    public StatusPret findByLibelle(@PathParam("libelle") String libelle) {
        return service.findByLibelle(libelle);
    }
}
