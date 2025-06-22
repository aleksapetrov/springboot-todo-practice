package com.todo.todo.controllers;

import com.todo.todo.entities.Token;
import com.todo.todo.entities.User;
import com.todo.todo.security.AuthenticationService;
import com.todo.todo.security.LoginDTO;
import com.todo.todo.security.RegistrationDTO;
import com.todo.todo.security.TokenDTO;
import com.todo.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("register")
    public ResponseEntity<TokenDTO> register(@RequestBody RegistrationDTO registrationDTO){
        TokenDTO tokenDTO = authenticationService.register(registrationDTO);
        return new ResponseEntity<>(tokenDTO, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO)   {
        TokenDTO tokenDTO = authenticationService.authenticate(loginDTO);
        return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
    }
}
