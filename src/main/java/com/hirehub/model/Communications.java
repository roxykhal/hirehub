package com.hirehub.model;

import java.util.Date;


public class Communications {

    private int applicationID;
    private int senderID;
    private int recipientID;
    private String message;
    private Date sentDate;
    private String type;


    //constructor

    public Communications() {

    }

    public Communications(int applicationID, int senderID, int recipientID, String message, Date sentDate, String type) {
        this.applicationID = applicationID;
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.message = message;
        this.sentDate = sentDate;
        this.type = type;
    }

    //getters and setters

    public int getapplicationID() {
        return applicationID;
    }

    public void setapplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public int getsenderID() {
        return senderID;
    }

    public void setsenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getrecipientID() {
        return recipientID;
    }

    public void setrecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public Date getsentDate() {
        return sentDate;
    }

    public void setsendDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }


}