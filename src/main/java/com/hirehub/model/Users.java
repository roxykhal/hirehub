package com.hirehub.model;

public class Users {

    private int userId;
    private String userName;
    private String password;
    private String email;
    private String role;

    //constructors

    public Users(){

    }

    public Users(int userId, String userName, String password, String email, String role){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    //getters and setters

    public int getuserId (){
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
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

    public String getpassword() {
        return password;
    } 

    public void setpassword(String password) {
        this.password = password;
    }
}