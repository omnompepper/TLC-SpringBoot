package com.claire.tlclabs.repos;

import com.claire.tlclabs.entities.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@Profile("dev")
public class LocalAccountRepository implements AccountRepository{
    private List<Account> accounts = new ArrayList<>();

    public LocalAccountRepository() {
        this.accounts.add(new Account(1, "Claire", 20));
        this.accounts.add(new Account(2, "Mike", 500));
        this.accounts.add(new Account(3, "Enock", 350));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account findAccountById(Long id) {
        return accounts.stream().filter(a->a.id()==id).findFirst().get();
    }

    @Override
    public void saveAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public void batchInsert(List<Account> accounts) {
        this.accounts.addAll(accounts);
    }
}
