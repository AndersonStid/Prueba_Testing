package com.prueba.certificacion.mispagos.stepdefinitions;

import com.prueba.certificacion.mispagos.interaction.EsperaExplicitaInteraction;
import com.prueba.certificacion.mispagos.questions.LoginValidateText;
import com.prueba.certificacion.mispagos.tasks.CreateEmployees;
import com.prueba.certificacion.mispagos.tasks.Employees;
import com.prueba.certificacion.mispagos.tasks.LoginCredentials;
import com.prueba.certificacion.mispagos.tasks.SeleccionarArchivoTask;
import com.prueba.certificacion.mispagos.utils.BaseTemplate;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.HashMap;
import java.util.Map;

import static com.prueba.certificacion.mispagos.userinterfaces.Login.*;
import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepsDefinitions {
    BaseTemplate Data = new BaseTemplate();
    Map<String, String> data = new HashMap<String, String>();
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Select URL")
    public void SelectUrl() {
        OnStage.theActorCalled("User").
                wasAbleTo(Open.browserOn().thePageNamed("pages.urlMisPagos"));
    }
    @When("^Select add two Courses (.*) and (.*)$")
    public void LoginCredentialsError(String User, String Password) {
        theActorInTheSpotlight().attemptsTo(LoginCredentials.write(User, Password));
    }
    @Then("^Validate text (.*)$")
    public void ValidateTextError(String Text) {
        theActorInTheSpotlight().should(seeThat(LoginValidateText.correct(TEXT_VALIDATE),
                equalTo(Text)));
    }
    @Then("^Create employees$")
    public void ValidateSuccessfullyText() {
            theActorInTheSpotlight().attemptsTo(Employees.clickPimButton());
    }

    @And("^Se selecciona archivo seleccionarArchivo (.*)$")
    public void seleccionaArchivo(String seleccionarArchivo) {
        Data.guardarDatos("seleccionarArchivo", String.valueOf(seleccionarArchivo));
        theActorInTheSpotlight().attemptsTo(EsperaExplicitaInteraction.porSegundos(3));
        theActorInTheSpotlight().attemptsTo(SeleccionarArchivoTask.seleccionarArchivoTask());
    }

    @And("^llenar formulario (.*) y (.*) y (.*) y (.*)$")
    public void LoginCredentialsError(String firstName, String middleName, String lastName, String EmployeeId) {
        theActorInTheSpotlight().attemptsTo(CreateEmployees.Employees(firstName, middleName,lastName, EmployeeId));
    }

    @Then("^Validate Employeed (.*)$")
    public void ValidateEmployeedError(String Employeed) {
        theActorInTheSpotlight().should(seeThat(LoginValidateText.correct(TEXT_VALIDATE_EMPLOYEED),
                equalTo(Employeed)));
    }
}


