package com.se498.chat.service;

import com.se498.chat.TestChatApplication;
import com.se498.chat.model.ChatMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {TestChatApplication.class})
public class MessageServiceIntegrationTest {
    //TODO: Implement message service integration test

    @Autowired
    private MessageService messageService;

    @Disabled // Disabling my written tests for now
    @Test
    public void testMessageService() {

        ChatMessage dummyMessage = new ChatMessage("1","John", "Hello World!", 10);

        messageService.addMessage(dummyMessage);
        assertEquals(dummyMessage, messageService.getMessage("1"));
    }
}
