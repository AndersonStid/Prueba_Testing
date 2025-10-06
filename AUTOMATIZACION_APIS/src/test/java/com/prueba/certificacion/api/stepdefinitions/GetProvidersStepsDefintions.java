package com.prueba.certificacion.api.stepdefinitions;

import com.prueba.certificacion.api.models.TestData;
import com.prueba.certificacion.api.questions.ValidateJson;
import com.prueba.certificacion.api.tasks.RequestApi;
import com.prueba.certificacion.api.utils.TemplatesConstants;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetProvidersStepsDefintions {

    @When("Load templates")
    public void callGenerateOTPMicroservice() {
        System.out.println(System.getProperty("base_url"));
        OnStage.theActorCalled("base_url").whoCan(CallAnApi.at(System.getProperty("base_url")));
        theActorInTheSpotlight().attemptsTo(RequestApi.get(TestData.getTestDataModel()));
    }

    @Then("Validate Json")
    public void validateJsonExit() {
        ValidateJson.validate(theActorInTheSpotlight(), TemplatesConstants.RESPONSE_JSON_EXIT.getTemplatePaths());
    }

    @Then("Validate Json Correct")
    public void validateJsonExitcORRECT() {
        ValidateJson.validate(theActorInTheSpotlight(), TemplatesConstants.VALIDATEJSONCORRECT.getTemplatePaths());
    }


    @Then("Validate Json error limit")
    public void validateJsonLimit() {
        ValidateJson.validateExactly(theActorInTheSpotlight(), TemplatesConstants.VALIDATEERRORLIMIT.getTemplatePaths());
    }

    @Then("Validate Json error offset")
    public void validateJsonOffset() {
        ValidateJson.validateExactly(theActorInTheSpotlight(), TemplatesConstants.VALIDATEERROROFFSET.getTemplatePaths());
    }

    @Then("Validate Json error model")
    public void validateJsonModel() {
        ValidateJson.validateExactly(theActorInTheSpotlight(), TemplatesConstants.VALIDATEERRORMODEL.getTemplatePaths());
    }

    @Then("Validate Json error includeEmployees")
    public void validateJsonIncludeEmployees() {
        ValidateJson.validateExactly(theActorInTheSpotlight(), TemplatesConstants.VALIDATEERRORINCLUDEEMPLOYEES.getTemplatePaths());
    }

    @Then("Validate Json error sortField")
    public void validateJsonSortField() {
        ValidateJson.validateExactly(theActorInTheSpotlight(), TemplatesConstants.VALIDATEERRORSORTFIELD.getTemplatePaths());
    }

    @Then("Validate Json error sortOrder")
    public void validateJsonSortOrder() {
        ValidateJson.validateExactly(theActorInTheSpotlight(), TemplatesConstants.VALIDATEERRSORORDER.getTemplatePaths());
    }

}
