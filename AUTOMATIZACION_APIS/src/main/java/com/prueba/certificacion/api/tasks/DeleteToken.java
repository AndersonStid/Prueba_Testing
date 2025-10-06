package com.prueba.certificacion.api.tasks;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static com.prueba.certificacion.api.utils.templates.HandlebarsTemplate.mergeWithTemplates;
import static io.restassured.http.ContentType.JSON;

public class DeleteToken implements Task, IsHidden {
    private final String template;
    private final String bodyName;
    private final Map<String, String> clientData;

    public DeleteToken(String template, String bodyName, Map<String, String> clientData) {
        this.template = template;
        this.bodyName = bodyName;
        this.clientData = clientData;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = mergeWithTemplates(template, bodyName, clientData);

        actor.attemptsTo(
                Post.to(System.getProperty("url_delete_tokens")).with(requestSpecification -> requestSpecification.contentType(JSON)
                        .body(body)
                )
        );
    }

    public static DeleteToken post(String template, String bodyName, Map<String, String> clientData) {
        return new DeleteToken(template, bodyName, clientData);
    }

}

