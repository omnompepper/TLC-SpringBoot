package com.claire.tlclabs.controllers;

import com.claire.tlclabs.entities.Account;
import com.claire.tlclabs.entities.OrderBook;
import com.claire.tlclabs.entities.Trade;
import com.claire.tlclabs.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.retrieveAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @GetMapping("/claire")
    public Account getFirstAccount() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
        return webClient.get()
                .uri("/accounts/1")
                .retrieve()
                .bodyToMono(Account.class)
                .block();
    }

}
