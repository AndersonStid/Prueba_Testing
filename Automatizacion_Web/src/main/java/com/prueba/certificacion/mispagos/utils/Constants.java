package com.prueba.certificacion.mispagos.utils;

public enum Constants {
    REMEMBER_DATA_RADENTRADA("src/test/resources/data/imagen/"),
    URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    private String constant = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    Constants(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
