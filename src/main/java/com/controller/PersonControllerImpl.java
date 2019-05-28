package com.controller;

import com.model.Person;
import com.service.PersonServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/persons")
public class PersonControllerImpl implements PersonController {
   PersonServiceImpl personServiceImpl= new PersonServiceImpl();

    @GET
    @Path("/persons-select")
    @Override
    public void select() {

     personServiceImpl.selectForService();

    }


    @DELETE
    @Path("/person-delete")
    @Override
    public void delete(@QueryParam("id") int id) {

     personServiceImpl.deleteForService(id);

    }
    @PUT
    @Path("/person-update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void update(Person person) {

     personServiceImpl.updateForService(person);

    }
    @POST
    @Path("/person-insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void insert(Person person)  {

            personServiceImpl.insertForService(person);


    }


}

