package com.banque.courant.rest;

import com.banque.courant.ejb.HistoriqueStatusService;
import com.banque.courant.entity.HistoriqueStatus;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/historiquestatus")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoriqueStatusRest {

    @Inject
    private HistoriqueStatusService service;

    @GET
    @Path("/all")
    public List<HistoriqueStatus> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public HistoriqueStatus getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public HistoriqueStatus create(HistoriqueStatus historique) { return service.create(historique); }

    @PUT
    @Path("/update/{id}")
    public HistoriqueStatus update(HistoriqueStatus historique) { return service.update(historique); }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
