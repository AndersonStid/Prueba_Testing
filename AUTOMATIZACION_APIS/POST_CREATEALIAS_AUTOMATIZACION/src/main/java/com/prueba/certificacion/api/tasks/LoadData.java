package com.prueba.certificacion.api.tasks;

import com.prueba.certificacion.api.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LoadData implements Task {

    private final Map<String, String> userData;
    public LoadData(Map<String, String> userData) {
        this.userData = userData;
    }

    public static Performable data(Map<String, String> userData) {
        return Tasks.instrumented(LoadData.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Set<Map.Entry<String, String>> testData = userData.entrySet();
        Map<String, String> stringTestData = testData.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> String.valueOf(entry.getValue())));
        TestData.setTestDataModel(stringTestData);
    }
}
