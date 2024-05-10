package com.se498.chat.service;

import com.se498.chat.TestChatApplication;
import com.se498.chat.model.ChatMessage;
import com.se498.chat.repository.FakeMessageRepository;
import com.se498.chat.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {TestChatApplication.class})
public class MessageServiceMockTest {
    //TODO: Implement message service Mock test

    @Autowired
    private MessageService messageService;

    @Qualifier("messageRepository")
    @Autowired
    private MessageRepository messageRepository;

    //@Disabled // Disabling my written tests for now
    @Test
    public void testGetAllMessages() {
        ChatMessage dummyMessage = new ChatMessage("1","John", "Hello World!", 10);

        given(messageRepository.save(any(ChatMessage.class))).willReturn(dummyMessage);
        messageService.addMessage(dummyMessage);
        verify(messageRepository, times(1)).save(dummyMessage);
    }
}
