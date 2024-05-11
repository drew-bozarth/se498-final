package com.se498.chat.model;

import lombok.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatChoice {
    private int index;
    private SimpleMessage message;

}
