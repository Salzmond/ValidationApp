package org.validation.example.com.dto;

import org.validation.example.com.entity.Account;

import java.util.List;

public class UserDto {

    private long id;
    private String name;
    private String email;

    private List<Account> accounts;

    public UserDto() {
        //
    }

    public UserDto(long id, String name, String email, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accounts = accounts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
