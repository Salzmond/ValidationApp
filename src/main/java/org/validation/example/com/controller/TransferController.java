package org.validation.example.com.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.validation.example.com.service.TransferService;
import org.validation.example.com.service.UserService;


@RestController
@RequestMapping("transfers")
public class TransferController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransferService transferService;

    @PostMapping
    public void transfer(@RequestParam long id1,
                         @RequestParam long id2,
                         @RequestParam int amount) {
        try {
            transferService.transfer(id1, id2, amount);
        } catch (ObjectNotFoundException ex) {
            System.out.printf("Account not found");
        }
    }
}