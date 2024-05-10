package com.se498.chat.repository;

import com.se498.chat.TestChatApplication;
import java.util.List;
import com.se498.chat.model.ChatMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageRepositoryMockTest {
    //TODO: Implement message repository Mock test

    @InjectMocks
    private FakeMessageRepository messageRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        List<ChatMessage> messages = messageRepository.findAll();
        assertEquals(5, messageRepository.count());
        // message 1
        assertEquals("1", messages.get(0).getMessageId());
        assertEquals("Hello World!", messages.get(0).getMessageText());
        assertEquals(10, messages.get(0).getSeed());
        // message 2
        assertEquals("2", messages.get(0).getMessageId());
        assertEquals("Foobar", messages.get(0).getMessageText());
        assertEquals(20, messages.get(0).getSeed());
        // message 3
        assertEquals("3", messages.get(0).getMessageId());
        assertEquals("words", messages.get(0).getMessageText());
        assertEquals(30, messages.get(0).getSeed());
        // message 4
        assertEquals("4", messages.get(0).getMessageId());
        assertEquals("test message", messages.get(0).getMessageText());
        assertEquals(40, messages.get(0).getSeed());
        // message 5
        assertEquals("5", messages.get(0).getMessageId());
        assertEquals("message test", messages.get(0).getMessageText());
        assertEquals(50, messages.get(0).getSeed());
    }
}
