package com.claire.tlclabs.entities;

public record ProductData (
        String TICKER,
        Integer SELL_LIMIT,
        Double LAST_TRADED_PRICE,
        Double MAX_PRICE_SHIFT,
        Double ASK_PRICE,
        Double BID_PRICE,
        Integer BUY_LIMIT
)
{}
