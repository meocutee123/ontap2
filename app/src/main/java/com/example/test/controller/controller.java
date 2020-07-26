package com.example.test.controller;

import android.app.Application;

import com.example.test.model.contact;

import java.util.ArrayList;
import java.util.List;

public class controller extends Application implements Icontroller{

    List<contact> contactList;

    public controller() {
        contactList = new ArrayList<>();
        contactList.add(new contact(1, "nguyễn minh hoàng", "1/12/2020", "033311223", "nha trang"));
        contactList.add(new contact(2, "nguyễn minh beron", "1/12/2020", "033311223", "nha trang"));
        contactList.add(new contact(3, "MH Beron", "1/12/2020", "033311223", "nha trang"));
    }

    @Override
    public List<contact> getAllcontact() {
        return contactList;
    }

    @Override
    public void edit(int id ,contact p) {
        for(contact c: contactList)
        {
            if(c.getID() == id)
            {
                c.setName(p.getName());
                c.setBir(p.getBir());
                c.setPhone(p.getPhone());
                c.setAddress(p.getAddress());

            }
        }
    }

    @Override
    public void add(contact p) {
        contactList.add(p);
    }
}
