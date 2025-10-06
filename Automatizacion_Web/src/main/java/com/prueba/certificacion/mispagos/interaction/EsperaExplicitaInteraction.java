package com.prueba.certificacion.mispagos.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class EsperaExplicitaInteraction implements Interaction {
    private long segundos;

    private EsperaExplicitaInteraction(long segundos) {
        this.segundos = segundos;
    }

    public static EsperaExplicitaInteraction porSegundos(long segundos) {
        return new EsperaExplicitaInteraction(segundos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(segundos * 1000); // Pausa en milisegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
