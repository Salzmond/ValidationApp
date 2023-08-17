package org.validation.example.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.validation.example.com.entity.Account;
import org.validation.example.com.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getById(long id) {
        return accountRepository.getReferenceById(id);
    }
}