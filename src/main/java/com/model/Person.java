package com.model;

import javax.ws.rs.QueryParam;

public class Person {
    @QueryParam("id")
    private int id;
    @QueryParam("name")
    private String name;
    @QueryParam("surname")
    private String surName;

    public Person() {

    }

    public  Person(int id , String name, String surName)
    {
        this.id  =id;
        this.name = name;
        this.surName = surName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "name  "+name+"  surname  "+surName+"  id : "+id;
    }
}
