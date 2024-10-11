public class Users {

    private int userID;
    private String userName;
    private String password;
    private String email;
    private String role('Recruiter', 'Hiring Manager', 'Interviewer', 'Admin');

    //constructors

    public Users(){

    }

    public Users(int userID, String userName, String password, String email, String role){
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    //getters and setters

    public int getuserID (){
        return userID;
    }

    public void setuserID(int userID) {
        this.userID = userID;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;

    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }

}