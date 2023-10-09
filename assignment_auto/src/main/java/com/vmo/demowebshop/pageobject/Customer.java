package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.utils.DataUtils;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String faxNumber;
    private String company;
    private String zipCode;
    private String address1;
    private String address2;
    private String country;
    private String city;

    public Customer(String country) {
        DataUtils dataUtils = new DataUtils();
        firstName = dataUtils.getFirstName();
        lastName = dataUtils.getLastName();
        email = dataUtils.generateNEmail();
        phoneNumber = dataUtils.getPhoneNumber();
        company = dataUtils.getCompanyName();
        address1 = dataUtils.getFirstNameAddress();
        address2 = dataUtils.getLastNameAddress();
        city = dataUtils.getCityName();
        zipCode = dataUtils.getZipCode();
        faxNumber = "1000";
        this.country = country;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getCompany() {
        return company;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
