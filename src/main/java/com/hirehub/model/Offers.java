public class Offers {

    private int offerID;
    private int applicationID;
    private boolean salary;
    private LocalDateTime startDate;
    private String status('Pending', 'Accepted', 'Rejected')

    //constructor

    public class Offers() {


    }

    public class Offers(int offerID, int applicationID, boolean salary, LocalDateTime startDate, String status) {
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

    oublic void setofferID(int offerID) {
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

    public LocalDateTime getstartDate() {
        return startDate;
    }

    public void setstartDate() {
        this.startDate = startDate;
    }

    public String getstatus() {
        return status;
    }

    
}