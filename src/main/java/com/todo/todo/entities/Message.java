package com.todo.todo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Chat chat;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    // DRUGI NAČIN

    // chat
    // id, name, isGroup

    // message
    // id, text, user, chat, localDateTime

    // chatmember

    // id, user, chat, grouprole



    // users/id/chats - GET, daje sve cetove u kojem se korisnik sa tim id-em nalazi
    // chats/id/messages - GET
    // chats/id/messages - POST

    // {"text": "zdravo ljudi!"}
}
