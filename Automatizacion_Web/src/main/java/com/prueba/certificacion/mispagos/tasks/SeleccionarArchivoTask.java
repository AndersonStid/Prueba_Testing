package com.prueba.certificacion.mispagos.tasks;

import com.prueba.certificacion.mispagos.interaction.EsperaExplicitaInteraction;
import com.prueba.certificacion.mispagos.interaction.SubirArchivoInteraction;
import com.prueba.certificacion.mispagos.utils.BaseTemplate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.prueba.certificacion.mispagos.userinterfaces.Login.BTN_CREAR_DOC_DIGITAL;
import static com.prueba.certificacion.mispagos.userinterfaces.Login.BTN_SELECCIONAR_ARCHIVO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarArchivoTask implements Task {
    public static SeleccionarArchivoTask seleccionarArchivoTask() {
        return instrumented(SeleccionarArchivoTask.class);
    }

    BaseTemplate data = new BaseTemplate();
    BaseTemplate Data = new BaseTemplate();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

               WaitUntil.the(BTN_CREAR_DOC_DIGITAL, WebElementStateMatchers.isClickable()).forNoMoreThan(30).seconds(),
                SubirArchivoInteraction.subirArchivoInteraction(data.obtenerDatos("seleccionarArchivo"), BTN_SELECCIONAR_ARCHIVO),
                EsperaExplicitaInteraction.porSegundos(3)
        );

    }
}
