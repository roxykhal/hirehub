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
            jobStatus status) {
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
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
