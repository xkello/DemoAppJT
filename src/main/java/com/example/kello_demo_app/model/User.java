package com.example.kello_demo_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    // User nick
    private String username;

    // User type
    private String userType;

    // Role/position
    private String role;

    // For team dropdown
    private String team;

    // Apparently this needs to be protected because such
    // constructor shouldn't be accessed from outside
    protected User() {
    }

    public User(String firstName, String lastName, String username, String userType, String role, String team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.userType = userType;
        this.role = role;
        this.team = team;
    }

    // Getter and setters
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
