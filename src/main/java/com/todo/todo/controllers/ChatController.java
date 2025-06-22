package com.todo.todo.controllers;

import com.todo.todo.entities.Chat;
import com.todo.todo.entities.ChatMember;
import com.todo.todo.entities.Message;
import com.todo.todo.services.ChatService;
import com.todo.todo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chats")
public class ChatController {

    @Autowired
    ChatService chatService;

    @Autowired
    MessageService messageService;

    // chats/id/messages - GET
    @GetMapping ("{id}/messages")
    public ResponseEntity<List<Message>> getMessagesInChat (@PathVariable long id) {
        Optional<Chat> chatOptional = chatService.findById(id);
        if (chatOptional.isPresent()) {
            Chat chat = chatOptional.get();
            List<Message> messageList = chatService.findAllMessagesInChat(chat);
            return new ResponseEntity<>(messageList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // chats/id/messages - POST
    @PostMapping ("{id}/messages")
    public ResponseEntity<Message> PostMessageInCategory (@PathVariable long id, @RequestBody Message message) {
        Optional<Chat> chatOptional = chatService.findById(id);
        if (chatOptional.isPresent()) {
            message.setChat(chatOptional.get());
            Message savedMessage = messageService.add(message);
            return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // chats/id/chat-member - GET
    @GetMapping ("{id}/chat-member")
    public ResponseEntity <List<ChatMember>> GetChatMembersInChat (@PathVariable long id) {
        Optional<Chat> chatOptional = chatService.findById(id);
        if (chatOptional.isPresent()) {
            Chat chat = chatOptional.get();
            List<ChatMember> chatMemberList = chatService.findAllChatMembers(chat);
            return new ResponseEntity<>(chatMemberList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
