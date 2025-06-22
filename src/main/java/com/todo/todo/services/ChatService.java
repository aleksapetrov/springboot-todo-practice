package com.todo.todo.services;

import com.todo.todo.entities.Chat;
import com.todo.todo.entities.ChatMember;
import com.todo.todo.entities.Message;
import com.todo.todo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ChatService {

    List<Chat> findByUser (User user);

    Optional<Chat> findById(long id);

    List<Message> findAllMessagesInChat (Chat chat);

    List<ChatMember> findAllChatMembers (Chat chat);

}
