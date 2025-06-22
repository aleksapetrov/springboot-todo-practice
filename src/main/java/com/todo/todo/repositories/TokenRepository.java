package com.todo.todo.repositories;

import com.todo.todo.entities.Token;
import com.todo.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    // jpa named queries
    Optional<Token> findByToken(String token);

    List<Token> findAllValidTokenByUser(User user);
}
