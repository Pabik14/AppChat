package com.chatapp.chatservice.service;

import com.chatapp.chatservice.domain.Message;

import java.time.LocalDateTime;
import java.util.List;

public interface ChatService {
    /**
     * Searches messages between first and second member before specified date.
     * Sorts messages by date (descending order).
     *
     * @param firstMemberId first chat's memberId
     * @param secondMemberId second chat's memberId
     * @param since datetime since which we should take a messages (excluding this message with exactly this datetime)
     * @param newer if true, method returns newer messages than given datetime
     * @return message list
     */
    List<Message> getMessages(Integer firstMemberId, Integer secondMemberId, LocalDateTime since, Boolean newer);

    /**
     * Checks that receiver with given id does exist.
     * Saves message in database if receiver exist.
     *
     * @param message
     * @return message
     */
    Message sendMessage(Message message);
}
