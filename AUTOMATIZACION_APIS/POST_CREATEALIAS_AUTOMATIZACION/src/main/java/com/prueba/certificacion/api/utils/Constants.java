package com.prueba.certificacion.api.utils;

public enum Constants {

    STATUS_CODE("Status code");

    private final String constants;

    Constants(String constants) {
        this.constants = constants;
    }

    public String getConstants() {
        return constants;
    }
}
