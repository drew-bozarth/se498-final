package com.se498.chat.repository;

import com.se498.chat.TestChatApplication;
import com.se498.chat.model.ChatMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {TestChatApplication.class})
public class MessageRepositoryIntegrationTest {
    //TODO: Implement message repository integration test

    @Autowired
    private MessageRepository messageRepository;


    //@Disabled // Disabling my written tests for now
    @Test
    public void testMessageRepository(){

        ChatMessage dummyMessage = new ChatMessage("1", "John", "Hello World!", 10);
        assertEquals (dummyMessage, messageRepository.save(dummyMessage));
    }
}
