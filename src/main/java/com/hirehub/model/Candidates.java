package com.hirehub.model;

import java.util.Date;

public class Candidates {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int phoneNumber; 
    private String resumeURL;
    private Date registrationDate;
    private int id;

// Constructors
    public Candidates() {
    }

    public Candidates(int id, String firstName, String lastName, String emailAddress, int phoneNumber, String resumeURL, Date registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.resumeURL = resumeURL;
        this.registrationDate = registrationDate;
        this.id = id;
    }

    //getters and setters

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getemailAddress() {
        return emailAddress;
    }

    public void setemailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    } 

    public String getresumeURL() {
        return resumeURL;

    }

    public void setresumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }

    public Date getregistrationDate() {
        return registrationDate;
    
    }

    public void setregistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }


}

