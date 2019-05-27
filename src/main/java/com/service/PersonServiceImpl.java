package com.service;

import com.dao.PersonDaoImpl;
import com.model.Person;

import java.sql.SQLException;

public class PersonServiceImpl implements PersonService {
    PersonDaoImpl personDaoImpl;
    public PersonServiceImpl()
    {

    }

    @Override
    public void selectForService() {
        personDaoImpl = new PersonDaoImpl();
        personDaoImpl.select();
    }

    @Override
    public void deleteForService(int id) {
        personDaoImpl = new PersonDaoImpl();
        personDaoImpl.delete(id);

    }

    @Override
    public void updateForService(Person person) {
        personDaoImpl = new PersonDaoImpl();
        personDaoImpl.update(person);
    }

    @Override
    public void insertForService(Person person)  {
        try {
            personDaoImpl = new PersonDaoImpl();
            personDaoImpl.insert(person);
            System.out.println("service  "+person.toString());

        }
        catch (Exception e)
        {
            System.out.println("service 39");
        }

    }

}
