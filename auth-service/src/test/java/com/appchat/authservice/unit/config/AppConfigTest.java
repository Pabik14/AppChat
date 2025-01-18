package com.appchat.authservice.unit.config;

import com.appchat.authservice.domain.user.User;
import com.appchat.authservice.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.appchat.authservice.utils.TestVariables.LOGIN_NAME;
import static com.appchat.authservice.utils.TestVariables.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("AppConfig")
public class AppConfigTest {
    @Autowired
    AuthenticationProvider authenticationProvider;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("AuthenticationProvider test")
    public void t1() {
        var user = new User();
        user.setLoginName(LOGIN_NAME);

        var encoded = passwordEncoder.encode(PASSWORD);

        user.setPassword(encoded);

        userRepository.save(user);

        var result = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(LOGIN_NAME, PASSWORD)
        );


        var principal = (User) result.getPrincipal();
        assertEquals(user.getId(), principal.getId());
        assertEquals(encoded, principal.getPassword());

        assertEquals(PASSWORD, result.getCredentials());
    }
}
