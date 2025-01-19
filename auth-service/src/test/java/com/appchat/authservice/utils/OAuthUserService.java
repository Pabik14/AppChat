package com.appchat.authservice.utils;

import com.appchat.authservice.domain.session.Session;
import com.appchat.authservice.domain.user.User;
import com.appchat.authservice.repository.SessionRepository;
import com.appchat.authservice.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.appchat.authservice.utils.TestVariables.LOGIN_NAME;
import static com.appchat.authservice.utils.TestVariables.PASSWORD;

@RequiredArgsConstructor
public class OAuthUserService {
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final PasswordEncoder passwordEncoder;

    @Getter
    private Session session;
    @Getter
    private Integer userId;

    public void createUserAndSession() {
        var encoded = passwordEncoder.encode(PASSWORD);

        var user = new User();
        user.setLoginName(LOGIN_NAME);
        user.setPassword(encoded);

        userRepository.save(user);
        userId = user.getId();

        session = new Session(user);
        sessionRepository.save(session);
    }

    public void cleanDatabase() {
        sessionRepository.deleteAll();
        userRepository.deleteAll();
    }

    public String getAccessToken() {
        return session.getAccessToken();
    }

    public String getAuthHeader() {
        return "Bearer " + this.getAccessToken();
    }
}
