package com.example.test.model;

public class contact {
    int ID;

    String name;
    String bir;
    String phone;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public contact(int ID, String name, String bir, String phone, String address) {
        this.ID = ID;
        this.name = name;
        this.bir = bir;
        this.phone = phone;
        this.address = address;
    }

    public contact() {
    }

    String address;

}
