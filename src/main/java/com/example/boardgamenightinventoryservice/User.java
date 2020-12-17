package com.example.boardgamenightinventoryservice;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id //Specifying Primary Key of the User Entity
    @Column(name = "User_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    @Column(name = "Game_Group_ID")
    private Integer gameGroupID;

    @Column(name = "Username")
    private String username;

    @Column(name = "Email_Address")
    private String emailAddress;

    @Column(name = "Pass_Word")
    private String password;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "User_Role")
    private String userRole;

    public Long getUserID(){
        return userID;
    }
    public void setUserID(Long id){
        this.userID = id;
    }

    public Integer getGameGroupID(){
        return gameGroupID;
    }
    public void setGameGroupID(Integer id){
        this.gameGroupID = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String address){
        this.emailAddress = address;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String pw){
        this.password = pw;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String name){
        this.firstName = name;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String name){
        this.lastName = name;
    }

    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String role){
        this.userRole = role;
    }
}