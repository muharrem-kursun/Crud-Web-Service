package com.controller;

import com.model.Person;
import com.service.PersonServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/crud")
public class PersonControllerImpl implements PersonController {
   PersonServiceImpl personServiceImpl= new PersonServiceImpl();

    public PersonControllerImpl()  {

    }
    @GET
    @Path("/sec")
    @Override
    public void select() {
        personServiceImpl.selectForService();
    }
    @DELETE
    @Path("/sil")
    @Override
    public void delete(@QueryParam("id") int id) {


     personServiceImpl.deleteForService(id);
    }
    @PUT
    @Path("/guncelle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void update(Person person) {
     personServiceImpl.updateForService(person);

    }
    @POST
    @Path("/ekle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void insert(Person person)  {

            personServiceImpl.insertForService(person);
        System.out.println(person.toString());

    }


}

