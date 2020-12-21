package com.example.boardgamenightinventoryservice;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id //Specifying Primary Key of the User Entity
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer usersID;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Integer getUsersID() {
        return usersID;
    }
    public void setUsersID(Integer usersID) {
        this.usersID = usersID;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}