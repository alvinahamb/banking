package com.banque.courant.rest;

import com.banque.courant.ejb.TypeOperationService;
import com.banque.courant.entity.TypeOperation;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/typeoperation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypeOperationRest {

    @Inject
    private TypeOperationService service;

    @GET
    @Path("/all")
    public List<TypeOperation> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public TypeOperation getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public TypeOperation create(TypeOperation typeOperation) { return service.create(typeOperation); }

    @POST
    @Path("/update/{id}")
    public TypeOperation update(TypeOperation typeOperation) { return service.update(typeOperation); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
