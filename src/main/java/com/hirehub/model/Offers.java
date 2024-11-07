package com.hirehub.model;
import java.util.Date;


public class Offers {

    private int offerID;
    private int applicationID;
    private boolean salary;
    private Date startDate;
    private String status;
    //constructor

    public Offers() {

    }

    public Offers(int offerID, int applicationID, boolean salary, Date startDate, String status) {
        this.offerID = offerID;
        this.applicationID = applicationID;
        this.salary = salary;
        this.startDate = startDate;
        this.status = status;
    }


    //getters and setters 

    public int getofferID() {
        return offerID;
    }

    public void setofferID(int offerID) {
        this.offerID = offerID;
    }

    public int getapplicationID() {
        return applicationID;
    }

    public void setapplicationID(int applicationID) {
        this.applicationID = applicationID;

    }

    public boolean getsalary() {
        return salary;
    }

    public void setsalary(boolean salary) {
        this.salary = salary;
    }

    public Date getstartDate() {
        return startDate;
    }

    public void setstartDate(Date starDate) {
        this.startDate = starDate;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    
}