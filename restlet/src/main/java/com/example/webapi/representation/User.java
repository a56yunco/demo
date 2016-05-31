package com.example.webapi.representation;

public class User {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private String firstName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    private String userlogin;


    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }


    private String lastName;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private String phone;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    private String userStatus;


    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

}
