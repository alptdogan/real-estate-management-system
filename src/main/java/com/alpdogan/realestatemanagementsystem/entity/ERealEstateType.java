package com.alpdogan.realestatemanagementsystem.entity;

public enum ERealEstateType {

    House("House"),
    Workplace("Workplace"),
    Land("Land");

    private String value;

    ERealEstateType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}