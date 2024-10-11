public class ScreeningQuestions {

    private int jobID;
    private String text;

    //constructor

    public class ScreeningQuestions() {

    }

    public class ScreeningQuestions(int jobID, String text) {
        this.jobID = jobID;
        this.text = text;
    }

    //getters and setters

    public int getjobID() {
        return jobID;
    }

    public void setjobID(int jobID) {
        this.jobID = jobID;
    }

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }
    


}