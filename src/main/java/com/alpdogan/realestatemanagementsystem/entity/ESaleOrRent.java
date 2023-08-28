package com.alpdogan.realestatemanagementsystem.entity;

public enum ESaleOrRent {

    Sale("Sale"),
    Rent("Rent");

    private String value;

    ESaleOrRent(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
