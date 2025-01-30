package com.hirehub.model;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
//import java.util.Objects;
import com.hirehub.model.Enums.applicationStatus;


public class Applications implements Serializable {

    private static final long serialVersionUID = 1L;

private Integer jobID;
private Integer candidateID;
private Date applicationDate;
private BigDecimal currentSalary;
private BigDecimal expectedSalary;
private Integer noticePeriod;
private Date createdAt;
private Date updatedAt;
private String applicationNotes;
private Integer lastUpdatedBy;
private applicationStatus status;
private String coverLetter;


//Default Constructors

public Applications() {
    this.applicationDate = new Date();
    this.createdAt = new Date();
    this.status = applicationStatus.APPLIED;
    this.jobID = jobID;
    this.candidateID = candidateID;
    this.applicationDate = applicationDate != null ? applicationDate : new Date(); // If applicationDate is null, use the current date
    this.currentSalary = currentSalary;
    this.expectedSalary = expectedSalary;
    this.createdAt = createdAt != null ? createdAt : new Date(); // If createdAt is null, use the current date
    this.updatedAt = updatedAt;
    this.applicationNotes = applicationNotes;
    this.lastUpdatedBy = lastUpdatedBy;
    this.status = status != null ? status : applicationStatus.APPLIED; // Default to "APPLIED" if status is null
    this.coverLetter = coverLetter;
    
}

//Constructor with required fields

public Applications(int jobID, int candidateID, Date applicationDate, String status) {
    this(); // Calling the default constructor to initialize default values for optional fields
    setjobID(jobID);
    setcandidateID(candidateID);
    setapplicationDate(applicationDate != null ? applicationDate : new Date()); // Use current date if null
    setstatus(status != null ? applicationStatus.valueOf(status) : applicationStatus.APPLIED); // Default to APPLIED if status is null
}


//Getters and setters with validation


public int getjobID() {
    return jobID;
}

public void setjobID(Integer jobID) {
   if (jobID == null || jobID <= 0) {
    throw new IllegalArgumentException("Invalid job ID"); 
}   
    this.jobID = jobID;
}

public int getcandidateID() {
    return candidateID;
}

public void setcandidateID(Integer candidateID) {
    if (candidateID == null || candidateID <= 0)
{ 
    throw new IllegalArgumentException("Invalid candidate ID");
}
    this.candidateID = candidateID;
}


public Date getapplicationDate() {
    return applicationDate != null ? new Date(applicationDate.getTime()) : null;
}

public void setapplicationDate(Date applicationDate){
    this.applicationDate = applicationDate != null ? new Date(applicationDate.getTime()) : null;
}

public applicationStatus getStatus() {
    return status;
}

public void setstatus(applicationStatus status) {
    if(status == null) {
        throw new IllegalArgumentException("Application status cannot be null");
    }
    this.status = status;
}

public BigDecimal getCurrentSalary() {
    return currentSalary;
}

public void setCurrencySalary(BigDecimal currencySalary) {
    if (currencySalary != null && currencySalary.compareTo(BigDecimal.ZERO) < 0) {
        throw new IllegalArgumentException("Current salary cannot be negative");
    }
    this.currentSalary = currencySalary;
}

public BigDecimal getExpectedSalary() {
    return expectedSalary;
}

public void setExpectedSalary(BigDecimal expectedSalary) {
    if (expectedSalary != null && expectedSalary.compareTo(BigDecimal.ZERO) < 0) {
        throw new IllegalArgumentException("Expected salary cannot be negative");
    }
    this.expectedSalary = expectedSalary;
}

public Integer getnoticePeriod() {
    return noticePeriod;
}

public void setNoticePeriod(Integer noticePeriod) {
    if (noticePeriod != null && noticePeriod < 0) {
        throw new IllegalArgumentException("Notice period cannot be negative");
    }
    this.noticePeriod = noticePeriod;
}

public String getcoverLetter() {
    return coverLetter;
}

public void setcoverLetter(String coverLetter) {
    this.coverLetter = coverLetter != null ? coverLetter.trim() : null;
}

public String getApplicationNotes() {
    return applicationNotes;
}

public void setApplicationNotes(String applicationNotes) {
    this.applicationNotes = applicationNotes != null ? applicationNotes.trim() : null;
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

public Integer getLastUpdatedby() {
    return lastUpdatedBy;
}

public void setLastUpdatedBy(Integer lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
}
}
//@override 

