package com.claire.tlclabs.repos;

import com.claire.tlclabs.entities.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> getAllAccounts();

    Account findAccountById(Long id);

    void saveAccount(Account account);

    void batchInsert(List<Account> accounts);
}
