package com.homework.reporting.security;

import com.homework.reporting.entity.User;
import com.homework.reporting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthManager implements AuthenticationManager {

    private final UserRepository userRepository;

    @Autowired
    public AuthManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String pass = (String) authentication.getCredentials();
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new AuthenticationCredentialsNotFoundException("Anonymous access denied");
        }
        else if (!user.getPassword().equals(pass)){
            throw new BadCredentialsException("bad username password combo");
        }
        return authentication;
    }
}
