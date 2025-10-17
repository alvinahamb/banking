package com.banque.pret.rest;

import com.banque.pret.ejb.TypePretService;
import com.banque.pret.entity.TypePret;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/typepret")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypePretRest {

    @Inject
    private TypePretService service;

    @GET
    @Path("/all")
    public List<TypePret> getAll() { return service.getAll(); }

    @GET
    @Path("/{id}")
    public TypePret getOne(@PathParam("id") Long id) { return service.getOne(id); }

    @POST
    @Path("/create")
    public TypePret create(TypePret type) { return service.create(type); }

    @POST
    @Path("/update/{id}")
    public TypePret update(TypePret type) { return service.update(type); }

    @GET
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
