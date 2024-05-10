package com.se498.chat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ChatMessage {

    //TODO: Implement Persistent Entity requirements
    @Id
    private String messageId;
    //@NonNull
    @Column
    private String username;
    //@NonNull
    @Column(length=2048)
    private String messageText;
    private int seed;

    public ChatMessage() {
        this.messageId = UUID.randomUUID().toString();
        this.username = "";
        this.messageText = "";
        this.seed = 0;
    }

    public ChatMessage(String username, String messageText, int seed) {
        this.messageId = UUID.randomUUID().toString();
        this.username = username;
        this.messageText = messageText;
        this.seed = seed;
    }

    public void setVisualizedContent(String content) {
        // No implementation needed
    }

    public String getVisualizedContent() {
        return "Visualized content";
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return seed == that.seed &&
                Objects.equals(messageId, that.messageId) &&
                Objects.equals(username, that.username) &&
                Objects.equals(messageText, that.messageText);
    }
}
