package com.example.authservice.dto;

public class AuthorizationResponse {
    private boolean authorized;
    private String message;

    public AuthorizationResponse(boolean authorized, String message) {
        this.authorized = authorized;
        this.message = message;
    }

    // Gettery i settery
    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
