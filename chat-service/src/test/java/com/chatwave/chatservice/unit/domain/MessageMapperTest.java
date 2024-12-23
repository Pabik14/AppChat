package com.chatapp.chatservice.unit.domain;

import com.chatapp.chatservice.domain.Message;
import com.chatapp.chatservice.domain.MessageMapper;
import com.chatapp.chatservice.domain.dto.SendMessageRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("MessageMapper")
public class MessageMapperTest {
     private final MessageMapper mapper = MessageMapper.INSTANCE;

     @Test
     @DisplayName("should map SendMessageRequest and authorId to message entity")
     void t1() {
         var createMessageRequest = new SendMessageRequest("It's a message.");
         var result = mapper.toMessage(createMessageRequest, 1, 2);

         assertEquals("It's a message.", result.getContent());
         assertEquals(1, result.getAuthorId());
         assertEquals(2, result.getReceiverId());

         assertNotNull(result.getCreatedAt());
     }

    @Test
    @DisplayName("should map Message entity to MessageResponse")
    void t2() {
        var message = new Message("It's a message.", 1,2);
        var result = mapper.toMessageResponse(message);

        assertEquals("It's a message.", result.content());
        assertEquals(1, result.authorId());
        assertEquals(2, result.receiverId());
        assertEquals(message.getCreatedAt(), result.createdAt());
    }
}
