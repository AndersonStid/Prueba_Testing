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
                "def5020021ef4fc9c8f96e153faa24d19ed3173142271aaa4ee789d36ba34d6145adb8c0b3a6db8913b6a81708c487ef5f767b68f0a9f7b97a07cdb9c5f27051fff27387be18d041e5f7b2a8ccb6f00ee156052ad5c308ad2ac25e47ce5f13bc11c31df58e86ccd7181e871dc558a806faebdba65888783b5127c9ef5c7093147204834b2194007abf34f4a9252f47ea37698a9a1c794b444bd12d3d6d7083af87c955c6"
        );
    }

    public static GenerateToken post(String template, String bodyName, Map<String, String> clientData) {
        return new GenerateToken(template, bodyName, clientData);
    }

}

