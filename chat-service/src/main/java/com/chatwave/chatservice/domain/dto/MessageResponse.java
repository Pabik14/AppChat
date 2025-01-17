package com.AppChat.chatservice.domain.dto;

import java.time.LocalDateTime;

public record MessageResponse(
        String content,
        Integer authorId,
        Integer receiverId,
        LocalDateTime createdAt
) {}
