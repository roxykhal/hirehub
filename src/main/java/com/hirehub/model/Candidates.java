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
        private String emailAddress;
        private int phoneNumber;
        private String resumeURL;
        private Date registrationDate;
        private Date createdAt;
        private Date updatedAt;
        private CandidateStatus Status;

        public enum CandidateStatus {
            ACTIVE, INACTIVE, BLACKLISTED
        }

    //default constructor 
    public Candidates() {
        this.registrationDate = new Date();
        this.createdAt = new Date();
        this.Status = CandidateStatus.ACTIVE;
    }

    //Constructor with required field
    public Candidates(String firstName, String lastName, String emailAdress, int phoneNumber) {
        this();
        setfirstName(firstName);
        setlastName(lastName);
        setemailAddress(emailAddress);
        setphoneNumber(phoneNumber);
    }



    //getters and setters

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
        }
    

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getId() {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }


}

