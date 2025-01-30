package com.hirehub.model;
import com.hirehub.model.Enums.jobStatus;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Job implements Serializable {

    //unique identifier to match class version during deserialization

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String description;
    private String requirements;
    private Date postingDate;
    private Date closingDate;
    private jobStatus status;
    private Date createdAt;
    private Date updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

    // Constructors
    public Job() {
        this.createdAt = new Date();
        this.status = jobStatus.DRAFT;
    }

    public Job(String title, String description, String requirements, Date postingDate, Date closingDate,
            String status) {
        this();        
        setTitle(title);
        setDescription(description);
        setRequirements(requirements);
        setPostingDate(postingDate);
        setClosingDate(closingDate);
        
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Job title cannot be empty");
        }
        this.title = title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Job description cannot be empty");
        }
        this.description = description.trim();
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        if(requirements == null || requirements.trim().isEmpty()) {
            throw new IllegalArgumentException("Job requirements cannot be empty");
    }
    this.requirements = requirements.trim();
    }

    public Date getPostingDate() {
        return postingDate != null ? new Date(postingDate.getTime()) : null;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate != null ? new Date(postingDate.getTime()) : null;
        
    }

   
    public Date getClosingDate() {
        return closingDate != null ? new Date(closingDate.getTime()) : null;
    }

    public void setClosingDate(Date closingDate) {
        if (closingDate != null && postingDate != null && closingDate.before(postingDate)) {
            throw new IllegalArgumentException("Closing date cannot be before posting date");
        }
        this.closingDate = closingDate != null ? new Date(closingDate.getTime()) : null;
    }

    public jobStatus getStatus() {
        return status;
    }

    public void setStatus(jobStatus status) {
        if(status == null) {
            throw new IllegalArgumentException("Job status cannot be null");
        }
        this.status = status;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    

    

}
