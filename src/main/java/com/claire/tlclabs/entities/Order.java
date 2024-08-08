package com.claire.tlclabs.entities;

public record Order (
        String product,
        Integer quantity,
        Double price,
        String side,
        String type
)
{}
