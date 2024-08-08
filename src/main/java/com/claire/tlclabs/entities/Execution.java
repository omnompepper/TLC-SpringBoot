package com.claire.tlclabs.entities;

public record Execution (
    String timestamp,
    Double price,
    Integer quantity
) {}
