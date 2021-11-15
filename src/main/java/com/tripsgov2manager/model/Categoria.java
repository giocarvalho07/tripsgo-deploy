package com.tripsgov2manager.model;

public enum Categoria {

    HOTEL("Hotel"),
    POUSADA("Pousada"),
    RESORT("Resort"),
    CHALE("Chalé");

    private String categoria;

    private Categoria (String categoria) {
        this.categoria = categoria;
    }
}
