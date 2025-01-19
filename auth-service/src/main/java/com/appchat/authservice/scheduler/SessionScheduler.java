package com.appchat.authservice.scheduler;

import com.appchat.authservice.domain.session.Session;
import com.appchat.authservice.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionScheduler {
    private final SessionRepository repository;

    /**
     * Changes accessToken and refreshToken to null if session is expired.
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void cleanupExpiredSessions() {
        var sessions =
                repository.findAllExpiredNotCleaned()
                .stream()
                .peek(Session::expire)
                .toList();

        repository.saveAll(sessions);
    }
}
