package com.chatapp.chatservice.integration;

import com.chatapp.authclient.filter.UserAuthFilter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ChatServiceApplicationTests {
    @MockBean
    private UserAuthFilter userAuthFilter;
    @Test
    void contextLoads() {
    }

}
