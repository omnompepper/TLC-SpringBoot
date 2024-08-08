package com.claire.tlclabs.services;

import com.claire.tlclabs.entities.Account;
import com.claire.tlclabs.repos.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalAccountService implements AccountService {

    private AccountRepository accountRepository;

    public LocalAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> retrieveAllAccounts() {
        System.out.println("LocalAccountService retrieving all accounts");
        return accountRepository.getAllAccounts();
    }

    @Override
    public void performBatchInsert(List<Account> accounts) {
        accountRepository.batchInsert(accounts);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public void createAccount(Account account) {
        accountRepository.saveAccount(account);
    }
}
