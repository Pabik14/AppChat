package com.chatapp.chatservice.config;

import com.chatapp.authclient.filter.UserAuthFilter;
import com.chatapp.chatservice.client.AuthClient;
import com.chatapp.chatservice.domain.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<String> activeProfiles(@Value("${spring.profiles.active}") List<String> activeProfiles) {
        return activeProfiles;
    }

    @Bean
    public MessageMapper messageMapper() {
        return MessageMapper.INSTANCE;
    }

    @Bean
    public UserAuthFilter userAuthFilter(@Autowired AuthClient authClient) {
        return new UserAuthFilter(authClient);
    }
}
