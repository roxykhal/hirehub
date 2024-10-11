public class Applications {

private int jobID;
private int candidateID;
private Date applicationDate;
private String status('Received', 'Screening', 'Interview', 'Offer', 'Hired', 'Rejected')

//Constructors

public Applications() {

}

public Applications(int jobID, int candidateID, Date applicationDate, String status) {
    this.jobID = jobID;
    this.candidateID = candidateID;
    this.applicationDate;
    this.status;
}

//getters and setters

public int getjobID() {
    return jobID;
}

public void setjobID(int jobID) {
    this.jobID = jobID;
}

public int getcandidateID() {
    return candidateID;
}

public void setcandidateID(int candidateID) {
    this.candidateID = candidateID;
}


public Date getapplicationDate() {
    return applicationDate;
}

public void setapplicationDate(Date applicationDate){
    this.applicationDate = applicationDate;
}

public String getstatus() {
    return status;
}

public void setstatus(String status) {
    this.status = status;
}



}