package com.prueba.certificacion.api.tasks;

import com.prueba.certificacion.api.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class RequestApi implements Task {

    private final Map<String, String> userData;

    public RequestApi(Map<String, String> userData) {
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String finalToken = System.getProperty("access_token");
        String authorizationFromTestData = TestData.getTestDataModel().get("Authorization");
        userData.remove("Authorization");
        actor.attemptsTo(
                Get.resource("/api/v2/pim/employees").with(requestSpecification -> {
                    requestSpecification.contentType(JSON)
                            .relaxedHTTPSValidation();
                    if (authorizationFromTestData != null && !authorizationFromTestData.trim().isEmpty()) {
                        requestSpecification.header("Authorization", "Bearer " + finalToken);
                    }
                    requestSpecification.params(userData);
                    return requestSpecification;
                })
        );
    }

    public static RequestApi get(Map<String, String> userData) {
        return new RequestApi(userData);
    }
}