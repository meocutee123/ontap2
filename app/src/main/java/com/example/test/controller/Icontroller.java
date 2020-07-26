package com.example.test.controller;

import com.example.test.model.contact;

import java.util.List;

public interface Icontroller {

    public List<contact> getAllcontact();
    public void edit(int id, contact p);
    public void add(contact p);
}
