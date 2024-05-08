package com.se498.chat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.Id;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ChatMessage {

    //TODO: Implement Persistent Entity requirements
    @Id
    private String messageId;
    @NonNull
    @Column
    private String username;
    @NonNull
    @Column
    private String messageText;
    
    private int seed;

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
