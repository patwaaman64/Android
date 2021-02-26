package com.example.firebase2;

public class Users {
    String username,age,mail,password,userId;

    public Users(String username, String age, String mail, String password, String userId) {
        this.username = username;
        this.age = age;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
    }
    public Users()
    {

    }
    //Signup constructor
    public Users(String username, String age, String mail, String password) {
        this.username = username;
        this.age = age;
        this.mail = mail;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
