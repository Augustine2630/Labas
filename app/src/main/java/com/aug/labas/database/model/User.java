package com.aug.labas.database.model;

public class User {

    private Integer id;

    private String name;

    private String number;

    private String address;

    private String date;

    public User() {
    }

    public User(Integer id, String name, String number, String address, String date) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "\n "+  id + ". " +
                name +
                " " + number +
                "\n  " + address +
                " " + date;
    }
}
