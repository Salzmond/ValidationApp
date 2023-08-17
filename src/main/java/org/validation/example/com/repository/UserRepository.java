package org.validation.example.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.validation.example.com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}