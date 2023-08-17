package org.validation.example.com.service;

import org.validation.example.com.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAll();
    Account save(Account account);

    Account getById(long id);
}