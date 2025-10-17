package com.banque.pret.rest.client;

import com.banque.pret.ejb.client.HistoriqueClientsService;
import com.banque.pret.entity.client.HistoriqueClients;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/historiqueclients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoriqueClientsRest {

    @Inject
    private HistoriqueClientsService service;

    @GET
    @Path("/all")
    public List<HistoriqueClients> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public HistoriqueClients getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public HistoriqueClients create(HistoriqueClients h) { return service.create(h); }

    @GET
    @Path("/update/{id}")
    public HistoriqueClients update(HistoriqueClients h) { return service.update(h); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
