package com.banque.courant.rest;

import com.banque.courant.ejb.HistoriqueVirementService;
import com.banque.courant.entity.HistoriqueVirement;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/historiquevirement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoriqueVirementRest {

    @Inject
    private HistoriqueVirementService service;

    @GET
    @Path("/all")
    public List<HistoriqueVirement> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public HistoriqueVirement getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public HistoriqueVirement create(HistoriqueVirement virement) { return service.create(virement); }

    @PUT
    @Path("/update/{id}")
    public HistoriqueVirement update(HistoriqueVirement virement) { return service.update(virement); }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
