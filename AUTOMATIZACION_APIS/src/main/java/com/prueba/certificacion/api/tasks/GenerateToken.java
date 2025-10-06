package com.prueba.certificacion.api.tasks;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static com.prueba.certificacion.api.utils.templates.HandlebarsTemplate.mergeWithTemplates;


public class GenerateToken implements Task, IsHidden {

    private final String template;
    private final String bodyName;
    private final Map<String, String> clientData;

    public GenerateToken(String template, String bodyName, Map<String, String> clientData) {
        this.template = template;
        this.bodyName = bodyName;
        this.clientData = clientData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        clientData.put("username",System.getProperty("username"));
        clientData.put("password",System.getProperty("password"));
        String body = mergeWithTemplates(template, bodyName, clientData);

        System.setProperty("access_token",
                "def502006829c5d25a9a06abb14f86a2fc7df9b2214f55263f253e887c31afb9af991411820b97d09fbdaf7960ff5f15604cabde37bc0475a65a35ea9163ff7a4e25d0c6c43f330f0734566e1424581708c4a691d8e32e042100d4da7546abc3124ac2a948276947e0f11b36fa2835530c69e5713dfcb1d50ef85cd6de7a15e408b9e6db8ebb59f7c9605cdeb78d44e383d60cc9561728222a9ae2572f4434a875f0741e"
        );
    }

    public static GenerateToken post(String template, String bodyName, Map<String, String> clientData) {
        return new GenerateToken(template, bodyName, clientData);
    }

}

