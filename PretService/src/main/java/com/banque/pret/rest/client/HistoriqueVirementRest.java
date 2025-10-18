package com.banque.pret.rest.client;

import com.banque.pret.entity.client.HistoriqueVirement;
import com.banque.pret.ejb.client.HistoriqueVirementService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/virements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoriqueVirementRest {

    @Inject
    private HistoriqueVirementService service;

    @POST
    @Path("/create")
    public void create(HistoriqueVirement virement) {
        service.create(virement);
    }

    @GET
    @Path("/{id}")
    public HistoriqueVirement find(@PathParam("id") Long id) {
        return service.find(id);
    }

    @GET
    @Path("/all")
    public List<HistoriqueVirement> findAll() {
        return service.findAll();
    }

    @POST
    @Path("/update/{id}")
    public HistoriqueVirement update(HistoriqueVirement virement) {
        return service.update(virement);
    }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}
