package com.se498.chat.repository;

import com.se498.chat.model.ChatMessage;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeMessageRepository{

    //TODO: Implement FakeMessageRepository
    private final List<ChatMessage> messages;

    public FakeMessageRepository() {
        this.messages = new ArrayList<>();
        messages.add(new ChatMessage("1", "John", "Hello World!", 10));
        messages.add(new ChatMessage("2", "Jill", "Foobar", 20));
        messages.add(new ChatMessage("3", "Joe", "words", 30));
        messages.add(new ChatMessage("4", "Jane", "test message", 40));
        messages.add(new ChatMessage("5", "Jake", "message test", 50));
    }

    public List<ChatMessage> findAll() {
        return messages;
    }

    public int count() {
        return messages.size();
    }

    public Optional<ChatMessage> findById(String id) {
        return messages.stream()
                .filter(message -> message.getMessageId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(ChatMessage message) {
        messages.add(message);
    }

    public void delete(ChatMessage message) {
        messages.remove(message);
    }

    public void deleteAll() {
        messages.clear();
    }
}
