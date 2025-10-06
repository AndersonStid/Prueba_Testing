package com.prueba.certificacion.mispagos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.prueba.certificacion.mispagos.userinterfaces.Login.*;


public class Employees implements Task {

    public static Employees clickPimButton() {
        return Tasks.instrumented(Employees.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(BTN_PIM).afterWaitingUntilEnabled());
        actor.attemptsTo(Click.on(BTN_EDIT).afterWaitingUntilEnabled());
    }
}
