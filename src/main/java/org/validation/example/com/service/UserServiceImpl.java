package org.validation.example.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.validation.example.com.entity.Account;
import org.validation.example.com.entity.User;
import org.validation.example.com.repository.UserRepository;

import java.util.List;

@Service
//@Profile("prod")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}