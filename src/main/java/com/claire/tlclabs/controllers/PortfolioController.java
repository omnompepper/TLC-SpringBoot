package com.claire.tlclabs.controllers;

import com.claire.tlclabs.entities.Portfolio;
import com.claire.tlclabs.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
@CrossOrigin
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public List<Portfolio> getPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postPortfolio(@RequestBody Portfolio portfolio) {
        portfolioService.createPortfolio(portfolio);
    }

}