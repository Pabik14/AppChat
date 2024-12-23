package com.chatapp.chatservice.unit.service;

import com.chatapp.chatservice.client.AccountClient;
import com.chatapp.chatservice.domain.Message;
import com.chatapp.chatservice.repository.ChatRepository;
import com.chatapp.chatservice.service.ChatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ChatService")
public class ChatServiceTest {
    @InjectMocks
    private ChatServiceImpl service;
    @Mock
    private ChatRepository repository;
    @Mock
    private AccountClient accountClient;

    private Message message;

    @BeforeEach
    void setup() {
        message = new Message();
        message.setReceiverId(2);
    }

    @Test
    @DisplayName("getMessages() should return return messages before specified date if newer value is false")
    void getMessages() {
        var datetime = LocalDateTime.now();

        when(
                repository.findMessagesBefore(1,2, datetime)
        ).thenReturn(List.of(message));

        var result = service.getMessages(1, 2, datetime, false);

        assertEquals(List.of(message), result);
    }

    @Test
    @DisplayName("getMessages() should return return messages after specified date if newer value is true")
    void getMessagesNewerTrue() {
        var datetime = LocalDateTime.now();

        when(
                repository.findMessagesAfter(1,2, datetime)
        ).thenReturn(List.of(message));

        var result = service.getMessages(1, 2, datetime, true);

        assertEquals(List.of(message), result);
    }

    @Test
    @DisplayName("sendMessage() should check that receiver exist, save and return message")
    void sendMessage() {
        var result = service.sendMessage(message);

        verify(
                repository, times(1)
        ).save(message);

        assertEquals(message, result);

        verify(
                accountClient, times(1)
        ).doesAccountExist(2);
    }
}
