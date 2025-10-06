package com.prueba.certificacion.mispagos.tasks;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.prueba.certificacion.mispagos.userinterfaces.Login.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CreateEmployees implements Task, IsSilent {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String EmployeeId;

    public CreateEmployees(String firstName, String middleName, String lastName, String EmployeeId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.EmployeeId = EmployeeId;
    }

    public static CreateEmployees Employees(String firstName, String middleName, String lastName, String EmployeeId ) {
        return Tasks.instrumented(CreateEmployees.class,firstName,middleName,lastName,EmployeeId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_FIRSTNAME, isEnabled()).forNoMoreThan(10).seconds(),
                Enter.theValue(firstName).into(BTN_FIRSTNAME),
                WaitUntil.the(BTN_MIDDLENAME, isEnabled()).forNoMoreThan(300).seconds(),
                Enter.theValue((middleName)).into(BTN_MIDDLENAME),
                WaitUntil.the(BTN_LASTNAME, isEnabled()).forNoMoreThan(10).seconds(),
                Enter.theValue((lastName)).into(BTN_LASTNAME),
                Enter.theValue((EmployeeId)).into(BTN_EMPLOYEEID),
                Click.on(BTN_SAVE).afterWaitingUntilEnabled());
    }
}