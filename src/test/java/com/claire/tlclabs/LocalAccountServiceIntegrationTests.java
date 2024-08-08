package com.claire.tlclabs;

import com.claire.tlclabs.entities.Account;
import com.claire.tlclabs.repos.AccountRepository;
import com.claire.tlclabs.services.AccountService;
import com.claire.tlclabs.services.LocalAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {LocalAccountService.class})
public class LocalAccountServiceIntegrationTests {

    @Autowired
    private LocalAccountService accountService;

    @MockBean
    private AccountRepository mockRepo;

    @Test
    void accountService_retrieveAllAccounts_calls_accountRepo_getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        given(mockRepo.getAllAccounts()).willReturn(accounts);
        accountService.retrieveAllAccounts();
        verify(mockRepo, times(1)).getAllAccounts();
    }
}
