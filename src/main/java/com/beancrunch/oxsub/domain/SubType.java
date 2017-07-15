package com.beancrunch.oxsub.domain;

public enum SubType {
    ROWER("Rower"),
    STOKESIDEROWER("Stroke Side Rower"),
    BOWSIDEROWER("Bow Side Rower"),
    COX("Cox"),
    XSTATUSCOX("X Status Cox"),
    SSTATUSCOX("S Status Cox");

    String value;

    SubType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
