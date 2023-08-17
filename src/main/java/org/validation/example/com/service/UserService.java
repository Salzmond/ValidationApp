package org.validation.example.com.service;

import org.validation.example.com.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(long id);

    User addUser(User user);
}
