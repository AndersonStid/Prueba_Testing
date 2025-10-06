package com.prueba.certificacion.api.stepdefinitions;

import com.prueba.certificacion.api.models.TestData;
import com.prueba.certificacion.api.tasks.GenerateToken;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.prueba.certificacion.api.utils.TemplatesConstants.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TokenStepDefinitions {
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("Generate Token")
    public void generateToken() {
        System.out.println(System.getProperty("url_token"));
        OnStage.theActorCalled("url_token").whoCan(CallAnApi.at(System.getProperty("url_token")));
        theActorInTheSpotlight().attemptsTo(GenerateToken.post(TOKEN_JSON.getTemplatePaths(), PATH_TEMPLATES.getTemplatePaths(),
                TestData.getTestDataModel()));
    }
}
