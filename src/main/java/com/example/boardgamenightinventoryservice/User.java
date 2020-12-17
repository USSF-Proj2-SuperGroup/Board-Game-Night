package com.example.boardgamenightinventoryservice;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Games> games = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Games> wishlist = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Group> groups = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Games> getGames() {
        return games;
    }

    public void setGames(Set<Games> games) {
        this.games = games;
    }

    public Set<Games> getWishlist() {
        return wishlist;
    }

    public void setWishlist(Set<Games> wishlist) {
        this.wishlist = wishlist;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}

//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "Users")
//public class User {
//
//    @Id //Specifying Primary Key of the User Entity
//    @Column(name = "User_ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer userID;
//
//    @OneToMany (mappedBy = "user")
//    Set<Inventory> user_games;
//
//    @Column(name = "Game_Group_ID")
//    private Integer gameGroupID;
//
//    @Column(name = "Username")
//    private String username;
//
//    @Column(name = "Email_Address")
//    private String emailAddress;
//
//    @Column(name = "Pass_Word")
//    private String password;
//
//    @Column(name = "First_Name")
//    private String firstName;
//
//    @Column(name = "Last_Name")
//    private String lastName;
//
//    @Column(name = "User_Role")
//    private String userRole;
//
//    public Integer getUserID(){
//        return userID;
//    }
//    public void setUserID(Integer id){
//        this.userID = id;
//    }
//
//    public Set<Inventory> getUser_games() {
//        return user_games;
//    }
//    public void setUser_games(Set<Inventory> user_games) {
//        this.user_games = user_games;
//    }
//
//    public Integer getGameGroupID(){
//        return gameGroupID;
//    }
//    public void setGameGroupID(Integer id){
//        this.gameGroupID = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//    public void setUsername(String username){
//        this.username = username;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//    public void setEmailAddress(String address){
//        this.emailAddress = address;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//    public void setPassword(String pw){
//        this.password = pw;
//    }
//
//    public String getFirstName(){
//        return firstName;
//    }
//    public void setFirstName(String name){
//        this.firstName = name;
//    }
//
//    public String getLastName(){
//        return lastName;
//    }
//    public void setLastName(String name){
//        this.lastName = name;
//    }
//
//    public String getUserRole() {
//        return userRole;
//    }
//    public void setUserRole(String role){
//        this.userRole = role;
//    }
//}