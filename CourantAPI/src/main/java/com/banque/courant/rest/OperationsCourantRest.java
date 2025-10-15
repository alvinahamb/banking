package com.banque.courant.rest;

import com.banque.courant.ejb.OperationsCourantService;
import com.banque.courant.entity.OperationsCourant;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/operationscourant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperationsCourantRest {

    @Inject
    private OperationsCourantService service;

    @GET
    @Path("/all")
    public List<OperationsCourant> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public OperationsCourant getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public OperationsCourant create(OperationsCourant operation) { return service.create(operation); }

    @PUT
    @Path("/update/{id}")
    public OperationsCourant update(OperationsCourant operation) { return service.update(operation); }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
