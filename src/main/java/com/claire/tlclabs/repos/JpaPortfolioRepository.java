package com.claire.tlclabs.repos;


import com.claire.tlclabs.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findAllPortfoliosByName(String name);
}
