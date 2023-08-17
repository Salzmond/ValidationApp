package org.validation.example.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.validation.example.com.converter.UserConverter;
import org.validation.example.com.dto.UserCreateDto;
import org.validation.example.com.dto.UserDto;
import org.validation.example.com.entity.User;
import org.validation.example.com.service.UserService;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter converter;

    @GetMapping
    List<UserDto> getAll() {
        return userService.getAll()
                .stream()
                .map(user -> converter.toDto(user)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    UserDto getById(@PathVariable(name = "id") long id) {
        return converter.toDto(userService.getById(id));
    }

    @PostMapping
    UserDto addUser(@RequestBody UserCreateDto user) {
        return converter.toDto(userService.addUser(converter.toEntity(user)));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> exceptionHandler(ConstraintViolationException ex) {
        Map<String, String> map = new HashMap<>();
        ex.getConstraintViolations().forEach(error -> {
            map.put(error.getPropertyPath().toString(), error.getMessage());
        });
        return map;
    }
}