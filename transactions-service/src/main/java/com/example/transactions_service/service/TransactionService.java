package com.example.transactions_service.service;

import com.example.transactions_service.model.Transaction;
import com.example.transactions_service.model.TransactionStatus;
import com.example.transactions_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Métodos para el CRUD
    public Transaction createTransaction(Transaction transaction) {
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsForAccount(Long accountId) {
        return transactionRepository.findBySourceAccountIdOrTargetAccountId(accountId, accountId);
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }
}