package com.claire.tlclabs.services;

import com.claire.tlclabs.entities.Portfolio;

import java.util.List;

public interface PortfolioService {
    List<Portfolio> getAllPortfolios();
    Portfolio createPortfolio(Portfolio portfolio);
    Portfolio returnPortfolioById(Long id);
}
