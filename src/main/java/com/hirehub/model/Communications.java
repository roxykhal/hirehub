public class Communications {

    private int applicationID;
    private int senderID;
    private int recipientID;
    private String message;
    private LocalDateTime sentDate;
    private String type ('Email', 'Phone', 'In-person')


    //constructor

    public class Communications() {

    }

    public class Communications(int applicationID, int senderID, int recipientID, String message, LocalDateTime sentDate, String type) {
        this.applicationID = applicationID;
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.message = message;
        this.sentDate = sentDate;
        this.type = type;
    }

    //getters and setters

    public int getapplicationID() {
        return applicationID;
    }

    public void setapplicationID(int applicationID) {
        this.applicationID;
    }

    public int getsenderID() {
        return senderID;
    }

    public void setsenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getrecipientID() {
        return recipientID;
    }

    public void setrecipientID(int recipientID) {
        this.recipientID = recipientID;
}

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public LocalDateTime getsentDate() {
        return sentDate;
    }

    public void setsendDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }