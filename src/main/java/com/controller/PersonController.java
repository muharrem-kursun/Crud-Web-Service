package com.controller;

import com.model.Person;

import javax.ws.rs.BeanParam;
import java.sql.SQLException;

public interface PersonController {
    public void select();
    public void delete(int id);
    public void update(Person person);
    public void insert(@BeanParam Person person) throws SQLException;
}
