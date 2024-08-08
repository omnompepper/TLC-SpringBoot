package com.claire.tlclabs.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Portfolio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="portfolio_id")
    private List<Trade> trades = new ArrayList<>();

    public Portfolio() { }

    public Portfolio(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trades=" + trades +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(id, portfolio.id) && Objects.equals(name, portfolio.name) && Objects.equals(trades, portfolio.trades);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(trades);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }
}
