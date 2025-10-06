package com.prueba.certificacion.api.models;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    private static Map<String, String> testDataModel = new HashMap<>();

    private TestData() {
    }

    public static Map<String, String> getTestDataModel() {
        return testDataModel;
    }

    public static void setTestDataModel(Map<String, String> testData) {
        TestData.testDataModel = testData;
    }
}
