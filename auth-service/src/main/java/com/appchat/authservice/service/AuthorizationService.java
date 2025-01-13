package com.example.authservice.service;

import com.example.authservice.model.UserRole;
import java.util.HashMap;
import java.util.Map;

public class AuthorizationService {
    private Map<String, UserRole> userRoles = new HashMap<>();

    public AuthorizationService() {
        // Mock data
        userRoles.put("adminUser", UserRole.ADMIN);
        userRoles.put("regularUser", UserRole.USER);
        userRoles.put("guestUser", UserRole.GUEST);
    }

    public boolean isAuthorized(String username, String action) {
        UserRole role = userRoles.get(username);

        if (role == null) {
            return false; // Użytkownik nie istnieje
        }

        switch (role) {
            case ADMIN:
                return true; // Admin ma dostęp do wszystkiego
            case USER:
                return !action.equals("DELETE"); // Użytkownicy nie mogą usuwać
            case GUEST:
                return action.equals("VIEW"); // Goście mogą tylko przeglądać
            default:
                return false;
        }
    }
}
