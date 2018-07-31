package com.mongo.springbootapp.model;

public class Address {
    private String house_no;
    private String address_line2;
    private String street;
    private String city;
    private String pincode;

    protected Address() {}

    public String getHouse_no() {
        return house_no;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }
}
