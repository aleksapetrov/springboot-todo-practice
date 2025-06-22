package com.todo.todo.security;

import com.todo.todo.entities.Role;
import com.todo.todo.entities.Token;
import com.todo.todo.entities.User;
import com.todo.todo.repositories.TokenRepository;
import com.todo.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenRepository tokenRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public TokenDTO register(RegistrationDTO registrationDTO) {
        User user = new User();

        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setRole(Role.USER);


        User savedUser = repository.save(user);
        String jwtToken = jwtService.generateToken(user); // ovo nece uvek da bude, na primer ako nije odmah loginovan posle registracije
        saveUserToken(savedUser, jwtToken);
        TokenDTO tokenDTO = new TokenDTO(jwtToken);
        return tokenDTO;
    }

    public TokenDTO authenticate(LoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                )
        );
        User user = repository.findByUsername(loginDTO.getUsername())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        TokenDTO tokenDTO = new TokenDTO(jwtToken);
        return tokenDTO;
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = new Token();
        token.setUser(user);
        token.setExpired(false);
        token.setRevoked(false);
        token.setToken(jwtToken);

        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user);
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }


    // Nepokretnost(abstraktna klasa), povrsina, cena, porez(abstraktna metoda)

    // Zemljiste, Kuca, Apartman (sve ovo klase nasledjuju Nepokretnost)
}
