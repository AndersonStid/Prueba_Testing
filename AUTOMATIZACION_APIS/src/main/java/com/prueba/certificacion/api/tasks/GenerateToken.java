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
                "def50200db52e60d01184bef343606b1ba6aeec9baf355916996e7ae503d3a5deabd3768b447995d0de0cebc2c10db6c102dac1f66aff3919d76d69333d84211c9c61d39f91888c71c15f77d4b22ca5ba41746d2a0c6a936471cd302bfd256ce83bd178a3fdcc5349129635dd5fd197c8816ad2bd0a6fec07b696295e7afc839746a482050ef46caaf37699fb53c9b92fb39b426eb8fe9e0708e4f0b063cead1d757d7f2"
        );
    }

    public static GenerateToken post(String template, String bodyName, Map<String, String> clientData) {
        return new GenerateToken(template, bodyName, clientData);
    }

}

