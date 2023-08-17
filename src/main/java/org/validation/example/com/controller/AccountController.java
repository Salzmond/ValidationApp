package org.validation.example.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.validation.example.com.entity.Account;
import org.validation.example.com.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping
    Account add(@RequestBody Account account) {
        return accountService.save(account);
    }
}