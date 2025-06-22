package com.todo.todo.services.impl;

import com.todo.todo.entities.Chat;
import com.todo.todo.entities.ChatMember;
import com.todo.todo.entities.Message;
import com.todo.todo.entities.User;
import com.todo.todo.repositories.ChatRepository;
import com.todo.todo.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatRepository chatRepository;


    @Override
    public List<Chat> findByUser(User user) {
        return chatRepository.findByUser(user);
    }

    @Override
    public Optional<Chat> findById(long id) {
        return chatRepository.findById(id);
    }

    @Override
    public List<Message> findAllMessagesInChat(Chat chat) {
        return chatRepository.findAllMessages(chat);
    }

    @Override
    public List<ChatMember> findAllChatMembers(Chat chat) {
        return chatRepository.findAllChatMembers(chat);
    }


}
