package pl.javaleader.chat.controllers;

import pl.javaleader.chat.model.Message;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {
 
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message getMessage(Message message) {
        return message;
    }
}