package com.prueba.certificacion.api.utils.templates;

import com.prueba.certificacion.api.exceptions.AssertionErrors;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.TemplateLoader;

import java.util.Map;

public class HandlebarsTemplate {

    private HandlebarsTemplate() {

    }

    public static String mergeWithTemplates(String templates, String templatesPath, Map<String, String> clientsData) {
        TemplateLoader templateLoader = new ClassPathTemplateLoader(templatesPath, " ");
        Handlebars handlebars = new Handlebars(templateLoader);
        Template template;
        try {
            template = handlebars.compile(templates);
        } catch (Exception e) {
            throw new AssertionErrors("Could not find templates " + templates, e);
        }
        String templateString;
        try {
            assert template != null;
            templateString = template.apply(clientsData);
        } catch (Exception e) {
            throw new AssertionErrors("Failed to merge test data templates", e);
        }
        return templateString;
    }
}