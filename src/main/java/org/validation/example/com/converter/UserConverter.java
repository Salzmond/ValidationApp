package org.validation.example.com.converter;

import org.validation.example.com.dto.UserCreateDto;
import org.validation.example.com.dto.UserDto;
import org.validation.example.com.entity.User;

public interface UserConverter {

    UserDto toDto(User user);

    User toEntity(UserCreateDto userCreateDto);
}