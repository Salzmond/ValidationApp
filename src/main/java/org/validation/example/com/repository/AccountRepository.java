package org.validation.example.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.validation.example.com.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
