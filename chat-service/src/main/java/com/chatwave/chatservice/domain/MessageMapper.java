package com.appchat.chatservice.domain;

import com.appchat.chatservice.domain.dto.MessageResponse;
import com.appchat.chatservice.domain.dto.SendMessageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);
    @Mapping(source = "sendMessageRequest.message", target = "content")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Message toMessage(SendMessageRequest sendMessageRequest, Integer authorId, Integer receiverId);
    MessageResponse toMessageResponse(Message message);
}
