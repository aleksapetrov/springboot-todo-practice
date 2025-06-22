package com.todo.todo.services.impl;

import com.todo.todo.entities.Message;
import com.todo.todo.repositories.MessageRepository;
import com.todo.todo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;


    @Override
    public Message add(Message message) {
        return messageRepository.save(message);
    }
}
