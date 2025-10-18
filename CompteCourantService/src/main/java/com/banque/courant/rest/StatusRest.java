package com.banque.courant.rest;

import com.banque.courant.ejb.StatusService;
import com.banque.courant.entity.Status;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusRest {

    @Inject
    private StatusService service;

    @GET
    @Path("/all")
    public List<Status> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public Status getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public Status create(Status status) { return service.create(status); }

    @POST
    @Path("/update/{id}")
    public Status update(Status status) { return service.update(status); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
