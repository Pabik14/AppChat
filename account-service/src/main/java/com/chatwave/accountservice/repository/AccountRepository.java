package com.appchat.accountservice.repository;

import com.appchat.accountservice.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByDisplayName(String displayName);
}
