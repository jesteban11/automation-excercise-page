package com.automationexcercise.entities;

import java.time.LocalDate;

public class User {
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String address;
    private String country;
    private String state;

    private String city;
    private String zipcode;
    private String mobileNumber;

    public User(String name, String lastName, LocalDate dateOfBirth, String email, String password, String address, String country, String state, String city, String zipcode, String mobileNumber) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.mobileNumber = mobileNumber;
    }
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }


}
