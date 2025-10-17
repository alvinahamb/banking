package com.banque.pret.rest.client;

import com.banque.pret.ejb.client.InformationProfessionnelService;
import com.banque.pret.entity.client.InformationProfessionnel;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/info")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InformationProfessionnelRest {

    @Inject
    private InformationProfessionnelService service;

    @GET
    @Path("/all")
    public List<InformationProfessionnel> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public InformationProfessionnel getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public InformationProfessionnel create(InformationProfessionnel i) { return service.create(i); }

    @GET
    @Path("/update/{id}")
    public InformationProfessionnel update(InformationProfessionnel i) { return service.update(i); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
