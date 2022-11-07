package com.example.customer_test;

public class Incoming_order {
    int id;
    String NAME;
    String Date;
    double price;

    public Incoming_order(int id, String NAME, String date, double price) {
        this.id = id;
        this.NAME = NAME;
        Date = date;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
