package com.claire.tlclabs.services;

import com.claire.tlclabs.entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> retrieveAllAccounts();
    void performBatchInsert(List<Account> accounts);
    Account getAccountById(Long id);
    void createAccount(Account account);
}
