package com.claire.tlclabs.services;

import com.claire.tlclabs.entities.Portfolio;
import com.claire.tlclabs.repos.JpaPortfolioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RealPortfolioService implements PortfolioService {

    @Autowired
    private JpaPortfolioRepository jpaPortfolioRepository;

    @Override
    public List<Portfolio> getAllPortfolios() {
        return jpaPortfolioRepository.findAll();
    }

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        return jpaPortfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio returnPortfolioById(Long id) {
        return jpaPortfolioRepository.getReferenceById(id);
    }
}
