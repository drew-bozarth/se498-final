package com.se498.chat.service;

import com.se498.chat.model.*;
import com.se498.chat.repository.FakeImageRepository;
import com.se498.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    AIService aiService;

    @Autowired
    FakeImageRepository fakeImageRepository;


    private final int seed = (int) (Math.random() * Integer.MAX_VALUE);

    public ChatMessage addMessage(ChatMessage message) {

        //TODO: Save original message in the database
        ChatMessage savedMessage = this.messageRepository.save(message);
        //TODO: Call AI service to visualize original message
        String originalMessageVisualization = aiService.visualizeMessage(message.getMessageText());
        //TODO: Save original message visualization in the database
        savedMessage.setVisualizedContent(visualizedMessage);
        messageRepository.save(savedMessage);
        //ChatMessage originalChatMessageVisualization = new ChatMessage(UUID.randomUUID().toString(), "User", originalMessageVisualization, seed);
        //messageRepository.save(originalChatMessageVisualization);
        
        //TODO: Call AI service to get response to the message
        String responseText = aiService.askQuestion(seed, message.getUsername(), message.getMessageText(), null);
        //String responseText = aiService.askQuestion(seed, "User", message.getMessageText(), null);
        
        //TODO: Save response in the database
        ChatMessage responseMessage = new ChatMessage();
        responseMessage.setUsername("AI");
        responseMessage.setMessageText(response);
        responseMessage.setSeed(seed);
        ChatMessage savedResponseMessage = messageRepository.save(responseMessage);
        //ChatMessage responseMessage = new ChatMessage(UUID.randomUUID().toString(), "System", responseText, seed);
        //messageRepository.save(responseMessage);

        //TODO: Call AI service to visualize response
        String responseVisualization = aiService.visualizeText(response);

        //TODO: Save visualized response in the database
        savedResponseMessage.setVisualizedContent(responseVisualization);
        messageRepository.save(savedResponseMessage);
        
        return savedMessage;
    }

    public List<ChatMessage> getChatMessages() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.messageRepository.findBySeed(seed).iterator(), Spliterator.ORDERED), false)
                       .collect(Collectors.toList());
    }

    public List<Image> getChatImages() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.fakeImageRepository.findAll().iterator(), Spliterator.ORDERED), false)
                .collect(Collectors.toList());
    }

    public ChatMessage getMessage(String id){
        //TODO: Implement retrieving message from database
        Optional<ChatMessage> optionalMessage = messageRepository.findById(id);
        return optionalMessage.orElse(null);
    }
}
