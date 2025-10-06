package com.prueba.certificacion.api.tasks;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static com.prueba.certificacion.api.utils.HandlebarsTemplate.mergeWithTemplates;


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
        clientData.put("username", System.getProperty("username"));
        clientData.put("password", System.getProperty("password"));

        String body = mergeWithTemplates(template, bodyName, clientData);

        System.setProperty("access_token",
                "def5020097d544742a22d3219094545082085d1ac86b7355d5332ace5c40bb2812d980e9e2e79ce6b54643f227c65d9f43cf515f3df6fa134bfe9f462e85733f192ede8d1d9069f5bb72ab3fe89e13867c7103a5aef10ccdc66663bb7bb91b18100aebd0123822f5cd02c0b61ec9dee0c786821eef7ceba3d7968b2d2a7ff2780e996c107f509738db51aeb56389cfdc4153a771d8ea7c6e236d49e9c8a930941cc16a85"
        );
    }

    public static GenerateToken post(String template, String bodyName, Map<String, String> clientData) {
        return new GenerateToken(template, bodyName, clientData);
    }

}

