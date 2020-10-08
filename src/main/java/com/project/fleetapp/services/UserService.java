package com.project.fleetapp.services;

import com.project.fleetapp.models.User;
import com.project.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void save(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }
}
