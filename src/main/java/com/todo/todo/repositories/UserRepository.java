package com.todo.todo.repositories;

import com.todo.todo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // named method queries in JPA/hibernate

    // definise metodu koja trazi korisnika po username

    Optional<User> findByUsername(String username);

    Page<User> findByUsernameContainingIgnoreCase(Pageable pageable, String username);


}
