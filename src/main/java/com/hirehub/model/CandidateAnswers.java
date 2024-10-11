public class CandidateAnswers() {

    private int applicationID;
    private int questionID;
    private String answer;


    //constructor 

    public class CandidateAnswers () {


    }

    public class CandidateAnswers(int applicationID, int questionID, String answer) {
        this.applicationID = applicationID;
        this.questionID = questionID;
        this.answer = answer;
    
}

    //getts and setters
    public int getapplicationID() {
        return applicationID;
    }

    public void setapplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public int getquestionID() {
        return questionID;
    }

    public void setquestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getanswer() {
        return answer;

    }

    public void setanswer(String answer) {
        this.answer = answer;
    }

}


