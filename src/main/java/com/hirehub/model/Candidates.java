package com.hirehub.model;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;;


// Constructors
    public class Candidates implements Serializable {
        private static final long serialVersionUID = 1L;

        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private int phoneNumber;
        private String resumeURL;
        private Date registrationDate;
        private Date createdAt;
        private Date updatedAt;
        private candidateStatus Status;

        public enum CandidateStatus {
            ACTIVE, INACTIVE, BLACKLISTED
        }

    //default constructor 
    public Candidates() {
        this.registrationDate = new Date();
        this.createdAt = new Date();
        this.status = CandidateStatus.ACTIVE;
    }
    


    //getters and setters

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

}