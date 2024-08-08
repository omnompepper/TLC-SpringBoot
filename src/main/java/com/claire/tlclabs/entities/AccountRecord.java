package com.claire.tlclabs.entities;

public record AccountRecord(
    int id,
    String name,
    double balance
) {
    public AccountRecord(int id, String name) {
        this(id, name, 0);
    }
}
