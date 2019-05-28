package com.service;

import com.dao.PersonDaoImpl;
import com.model.Person;



public class PersonServiceImpl implements PersonService {
    PersonDaoImpl personDaoImpl;

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


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
