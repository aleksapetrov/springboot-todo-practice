package com.todo.todo.repositories;

import com.todo.todo.entities.Chat;
import com.todo.todo.entities.ChatMember;
import com.todo.todo.entities.Message;
import com.todo.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query (value = "SELECT cm.chat FROM ChatMember cm WHERE cm.user = :user")
    List<Chat> findByUser(User user);

    @Query (value = "SELECT m FROM Message m WHERE m.chat = :chat")
    List<Message> findAllMessages(@Param("chat") Chat chat);

    @Query (value = "SELECT cm FROM ChatMember cm WHERE cm.chat = :chatMember")
    List<ChatMember> findAllChatMembers(@Param("chatMember") Chat chatMember);

}
