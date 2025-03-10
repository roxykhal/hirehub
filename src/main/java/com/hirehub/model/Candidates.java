package com.hirehub.model;
import java.util.Date;
//import java.util.Objects;
import java.io.Serializable;;


// Constructors
    public class Candidates implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private String phoneNumber;
        private String resumeURL;
        private Date registrationDate;
        private Date createdAt;
        private Date updatedAt;
        private String status;

        

    //default constructor, sets candidate as active
    public Candidates(){
        this.registrationDate = new Date();
        this.status = "ACTIVE";
    }

    //Constructor with required field
    public Candidates(String firstName, String lastName, String emailAdress, String phoneNumber, String resumeURL) {
        setfirstName(firstName);
        setlastName(lastName);
        setemailAddress(emailAddress);
        setphoneNumber(phoneNumber);
        setresumeURL(resumeURL);
    }



    //getters and setters with validation

    public Integer getId() {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        if(firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
            }
            this.firstName = firstName.trim();
        }

    public String getlastName() {
            return lastName;
        }
    
    public void setlastName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
            }
            this.lastName = lastName.trim();
        }

    public String getemailAddress() {
            return emailAddress;
        }
    
    public void setemailAddress(String emailAddress) {
            if(emailAddress == null || !emailAddress.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.emailAddress = emailAddress.toLowerCase().trim();
    }
        
    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber2) {
            this.phoneNumber = phoneNumber2; {
                if(phoneNumber2 == null || !phoneNumber2.matches("^\\+?[0-9]{10,15}$")) {
                throw new IllegalArgumentException("Invalid phone number format");
            }
            this.phoneNumber = phoneNumber2.trim();
        }
        }

    public String getresumeURL() {
            return resumeURL;
    
        }
    
    public void setresumeURL(String resumeURL) {
            this.resumeURL = resumeURL != null ? resumeURL.trim() : null;
        }

    public Date getregistrationDate() {
            return registrationDate;
        
        }
    
    public void setregistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate != null ? new Date(registrationDate.getTime()) : null; 
        }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if( status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }

    }

    public Date getCreatedAt() {
        return createdAt != null ? new Date(createdAt.getTime()) : null;
    }

    protected void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt != null ? new Date(createdAt.getTime()) : null;

    }

    public Date getUpdatedAt() {
        return updatedAt != null ? new Date(updatedAt.getTime()) : null;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt != null ? new Date(updatedAt.getTime()) : null;
    }


}

