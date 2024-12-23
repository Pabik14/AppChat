package com.appchat.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.SECONDS;

@Getter
public class ApiException {
    private final String message;
    private final HttpStatusCode status;
    private final LocalDateTime timestamp;

    public ApiException(String message, HttpStatusCode status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now().truncatedTo(SECONDS);
    }
}
