package com.prueba.certificacion.api.stepdefinitions;

import com.prueba.certificacion.api.utils.Constants;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ResponseCode {
    @Then("Api response code {int}")
    public void apiResponseCode(int responseCode) {
        theActorInTheSpotlight().should(
                seeThatResponse(String.format(Constants.STATUS_CODE.getConstants()),
                        response -> response.statusCode(responseCode))
        );
    }

}