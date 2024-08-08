package com.claire.tlclabs.entities;

import java.util.ArrayList;

public record OrderBook (
        String product,
        Integer quantity,
        Double price,
        String side,
        ArrayList<Execution> executions,
        String orderID,
        String orderType,
        Integer cumulatitiveQuantity,
        Double cumulatitivePrice
)
{}
