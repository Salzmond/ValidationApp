package org.validation.example.com.converter;

import org.springframework.stereotype.Service;
import org.validation.example.com.dto.UserCreateDto;
import org.validation.example.com.dto.UserDto;
import org.validation.example.com.entity.User;

@Service
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getAccounts());
    }

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return new User(userCreateDto.getName(),userCreateDto.getEmail(), userCreateDto.getAccounts());
    }
}