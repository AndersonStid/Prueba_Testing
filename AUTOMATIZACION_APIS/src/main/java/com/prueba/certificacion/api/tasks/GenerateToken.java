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
                "def50200ba210c22d93a54b638d34a9ff6120aeb4cef7b7bafd11a01ea78c29a4cc5ac1babbc132d87e5cede224fcade2bbe0ba0bf454a970d16f4df35f5ab92672e6220601dbc7e3ed31cb6ea899ba45d07d02e31abe833cdecb7b0d6f8924b6a37abc631f1f7fc811dae9540a86924a3cca19595906ab36087f3e97a7a21b482552e5832b7e8f9dbdfa36bb6fda5d74d30e52928e2723cd837fceb60024f53c33b1391"
        );
    }
    public static GenerateToken post(String template, String bodyName, Map<String, String> clientData) {
        return new GenerateToken(template, bodyName, clientData);
    }
}

