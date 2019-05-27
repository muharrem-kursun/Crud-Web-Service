package com.service;

import com.model.Person;

import java.sql.SQLException;

public interface PersonService {
    public void selectForService();
    public void deleteForService(int id);
    public void updateForService(Person person);
    public void insertForService(Person person) throws SQLException;
}
