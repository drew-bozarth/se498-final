package com.se498.chat.model;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import com.se498.chat.model.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    //TODO: Implement message test

    //@Disabled // Disabling my written tests for now
    @Test
    void testMessageInstantiation() {

        ChatMessage dummyMessage = new ChatMessage("1","John", "Hello World!", 10);

        assertAll("Verify Account properties",
                () -> assertEquals("1", dummyMessage.getMessageId()),
                () -> assertEquals("John", dummyMessage.getUsername()),
                () -> assertEquals("Hello World!", dummyMessage.getMessageText()),
                () -> assertEquals(10, dummyMessage.getSeed()));

    }

    
}
