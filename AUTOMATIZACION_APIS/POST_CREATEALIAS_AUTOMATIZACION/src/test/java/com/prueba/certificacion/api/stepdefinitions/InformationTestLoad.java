package com.prueba.certificacion.api.stepdefinitions;

import com.prueba.certificacion.api.tasks.LoadData;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

public class InformationTestLoad {

    @Given("^Load customer information$")
    public void loadCustomerInformation(List<Map<String, String>> userData) {
        OnStage.theActorCalled("get").wasAbleTo(LoadData.data(userData.get(0)));
    }

}