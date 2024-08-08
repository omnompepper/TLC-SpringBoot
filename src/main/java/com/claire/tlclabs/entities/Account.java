package com.claire.tlclabs.entities;

import org.springframework.context.annotation.EnableMBeanExport;

public record Account(
        int id,
        String name,
        double balance
) {
    public Account(int id, String name) {
        this(id, name, 0);
    }
}