package com.alpdogan.realestatemanagementsystem.entity;

public enum ETown {

    Altınova("Altınova"),
    Armutlu("Armutlu"),
    Çınarcık("Çınarcık"),
    Çiftlikköy("Çiftlikköy"),
    Merkez("Merkez"),
    Termal("Termal");

    private String value;

    ETown(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
