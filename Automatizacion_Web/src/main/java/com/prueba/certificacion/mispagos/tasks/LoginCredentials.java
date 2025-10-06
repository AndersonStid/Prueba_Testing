package com.prueba.certificacion.mispagos.tasks;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.prueba.certificacion.mispagos.userinterfaces.Login.*;

public class LoginCredentials implements Task, IsSilent {
    private final String user;
    private final String password;

    public LoginCredentials(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static LoginCredentials write(String user, String password) {
        return Tasks.instrumented(LoginCredentials.class,user,password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(TXT_USER),
                Enter.theValue((password)).into(TXT_PASSWAORD),
                Click.on(BTN_GET_INTO).afterWaitingUntilEnabled());
    }
}