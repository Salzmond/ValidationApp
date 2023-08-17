package org.validation.example.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.validation.example.com.entity.Account;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountService accountService;

    @Override
    public void transfer(long idOne, long idTwo, int amount) {
        Account accountOne = accountService.getById(idOne);
        if (accountOne.getAmount() - amount < 0) {
            throw new IllegalArgumentException("Not enough amount on account one");
        }

        accountOne.setAmount(accountOne.getAmount() - amount);
        accountService.save(accountOne);

        Account accountTwo = accountService.getById(idTwo);
        accountTwo.setAmount(accountTwo.getAmount() + amount);
        accountService.save(accountTwo);
    }
}