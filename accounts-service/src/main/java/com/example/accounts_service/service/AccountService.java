package com.example.accounts_service.service;

import com.example.accounts_service.model.Account;
import com.example.accounts_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // CREATE
    public Account createAccount(Account account) {
        if (accountRepository.existsByAccountNumber(account.getAccountNumber())) {
            throw new IllegalArgumentException("Account number already exists.");
        }
        account.setBalance(BigDecimal.ZERO); // El saldo inicial es cero
        return accountRepository.save(account);
    }

    // READ
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> findByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    // UPDATE
    public Account updateBalance(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found."));

        account.setBalance(account.getBalance().add(amount));
        return accountRepository.save(account);
    }
}