package com.hirehub.model;

import java.util.Date;

public class Job {
    private int id;
    private String title;
    private String description;
    private String requirements;
    private Date postingDate;
    private Date closingDate;
    private String status;

    // Constructors
    public Job() {
    }

    public Job(String title, String description, String requirements, Date postingDate, Date closingDate,
            String status, int id) {
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.postingDate = postingDate;
        this.closingDate = closingDate;
        this.status = status;
        this.id = id;
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
        this.title = title;
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
