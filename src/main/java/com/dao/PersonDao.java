package com.dao;

import com.model.Person;

import java.sql.Connection;
import java.sql.SQLException;

public interface PersonDao {
    public void select();
    public void delete(int id);
    public void update(Person person);
    public void insert(Person person) throws SQLException;
    public Connection getConnection() throws SQLException;

}
