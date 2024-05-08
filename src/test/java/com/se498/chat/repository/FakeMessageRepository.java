package com.se498.chat.repository;

import com.se498.chat.model.ChatMessage;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class FakeMessageRepository{

    //TODO: Implement FakeMessageRepository

    private final Map<String, ChatMessage> db = new HashMap<>();


    public void delete(ChatMessage arg0) {
    }

    //@Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    public void deleteAll() {
    }

    public void deleteAll(Iterable<? extends ChatMessage> arg0) {
    }

    public void deleteById(String arg0) {
    }

    public boolean existsById(String arg0) {
        return false;
    }

    public Iterable<ChatMessage> findAll() {
        return this.db.values();
    }

    public Iterable<ChatMessage> findAllById(Iterable<String> arg0) {

        return null;
    }

    //@Override
    public long count() {
        return 0;
    }

    public Optional<ChatMessage> findById(String arg0) {
        return Optional.of(this.db.get(arg0));
    }

    public <S extends ChatMessage> S save(S arg0) {
        this.db.put(arg0.getUsername(), arg0);
        return arg0;
    }

    public <S extends ChatMessage> Iterable<S> saveAll(Iterable<S> arg0) {
        return null;
    }
}
