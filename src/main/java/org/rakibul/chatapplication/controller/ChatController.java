package org.rakibul.chatapplication.controller;

import org.rakibul.chatapplication.model.ChatMessage;


import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;


import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }


    @MessageMapping("/private-message")
    public void sendPrivateMessage(ChatMessage message) {

        messagingTemplate.convertAndSendToUser(
                message.getSender(),   // receiver username
                "/queue/messages",
                message
        );
    }

}
