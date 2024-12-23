package com.chatapp.chatservice.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record SendMessageRequest(
        @NotEmpty(message = "The message can not be empty")
        @Length(max = 2000, message = "The message can have at most 2000 characters.")
        String message
) {}
