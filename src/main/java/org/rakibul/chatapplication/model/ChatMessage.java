package org.rakibul.chatapplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private Long id;
    private String sender;
    private String receiver;
    private String content;
    private String roomId;
    private MessageType type;

    public enum MessageType {
        CHAT, JOIN, LEAVE, SYSTEM
    }



}
