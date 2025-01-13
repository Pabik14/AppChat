package com.example.authservice.dto;

public class AuthorizationRequest {
    private String username;
    private String action;

    public AuthorizationRequest(String username, String action) {
        this.username = username;
        this.action = action;
    }

    // Gettery i settery
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
