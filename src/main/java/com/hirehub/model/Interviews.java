public class Interviews {

    private int interviewID;
    private int applicationID;
    private Date interviewDate;
    private String feedback;
    private String status('Scheduled', 'Completed', 'Cancelled');

    //constructor

    public Interviews() {

    }
    
    public Interviews(int interviewID, int applicationID, Date interviewDate, String feedback, String status) {
        this.interviewID = interviewID;
        this.applicationID = applicationID;
        this.interviewDate = interviewDate;
        this.feedback = feedback;
        this.status = status;
    }

    //getters and setters 

    public int getinterviewID() {
        return getinterviewID;
    }

    public void setinterviewID(int interviewID) {
        this.interviewID = interviewID;
    }

    public int getapplicationID() {
        return getapplicationID;
    }

    public void setapplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public Date getinterviewDate() {
        return interviewDate;
    }

    public void setinterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate
 
    }

    public String getfeedback() {
        return feedback;
    }

    public void setfeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }










}