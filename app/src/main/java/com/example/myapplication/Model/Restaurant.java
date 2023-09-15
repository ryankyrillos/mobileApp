package com.example.myapplication.Model;

public class Restaurant {

    private String name;
    private String address;

    private boolean onTable;

    private boolean delivery;

    private boolean takeAway;


    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.delivery = false;
        this.onTable = false;
        this.takeAway = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isOnTable() {
        return onTable;
    }

    public void setOnTable(boolean onTable) {
        this.onTable = onTable;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean isTakeAway() {
        return takeAway;
    }

    public void setTakeAway(boolean takeAway) {
        this.takeAway = takeAway;
    }
}