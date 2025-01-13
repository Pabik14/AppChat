package com.example.authservice.controller;

import com.example.authservice.dto.AuthorizationRequest;
import com.example.authservice.dto.AuthorizationResponse;
import com.example.authservice.service.AuthorizationService;

public class AuthorizationController {
    private AuthorizationService authorizationService = new AuthorizationService();

    public AuthorizationResponse authorize(AuthorizationRequest request) {
        boolean isAuthorized = authorizationService.isAuthorized(request.getUsername(), request.getAction());
        String message = isAuthorized ? "Action authorized" : "Action not authorized";
        return new AuthorizationResponse(isAuthorized, message);
    }
}
