package com.claire.tlclabs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Trade implements Serializable {

    private enum Side{BUY, SELL}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticker;
    private Double price;
    private Side side;

    public Trade() {}

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", ticker='" + ticker + '\'' +
                ", price=" + price +
                ", side=" + side +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trade trade = (Trade) o;
        return Objects.equals(id, trade.id) && Objects.equals(ticker, trade.ticker) && Objects.equals(price, trade.price) && side == trade.side;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(ticker);
        result = 31 * result + Objects.hashCode(price);
        result = 31 * result + Objects.hashCode(side);
        return result;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Trade(Long id, String ticker, Double price, Side side) {
        this.id = id;
        this.ticker = ticker;
        this.price = price;
        this.side = side;
    }
}
