package com.banque.pret.rest;

import com.banque.pret.ejb.EcheanceService;
import com.banque.pret.entity.Echeance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/echeance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EcheanceRest {

    @Inject
    private EcheanceService service;

    @GET
    @Path("/all")
    public List<Echeance> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public Echeance getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public Echeance create(Echeance e) { return service.create(e); }

    @POST
    @Path("/update/{id}")
    public Echeance update(Echeance e) { return service.update(e); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }

    @GET
    @Path("/byPret/{id}")
    public List<Echeance> getEcheancesByPret(@PathParam("id") Long idPret) {
        return service.getByPretId(idPret);
    }

    @GET
    @Path("/lastEnCours/{idPret}")
    public Echeance getLastEcheanceEnCours(@PathParam("idPret") Long idPret) {
        return service.getLastEcheanceEnCours(idPret);
    }
}
