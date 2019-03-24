package com.homework.reporting.service;

import com.homework.reporting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingService {

    private final UserRepository userRepository;

    @Autowired
    public ReportingService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean isEven(int x){
        return x % 2 == 0;
    }

    /* public Cart getCart(Long id){
        return cartRepository.findById(id).isPresent() ? cartRepository.findById(id).get() : null;
    } */

}
