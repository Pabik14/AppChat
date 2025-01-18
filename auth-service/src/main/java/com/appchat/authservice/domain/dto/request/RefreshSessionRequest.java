package com.appchat.authservice.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record RefreshSessionRequest(
        @NotEmpty(message = "The refreshToken can not be empty.")
        String refreshToken
){}
