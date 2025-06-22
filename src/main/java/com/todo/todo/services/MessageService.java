package com.todo.todo.services;

import com.todo.todo.entities.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

    Message add(Message message);

}
