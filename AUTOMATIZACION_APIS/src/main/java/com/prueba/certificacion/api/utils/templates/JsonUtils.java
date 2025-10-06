package com.prueba.certificacion.api.utils.templates;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JsonUtils {
    private JsonUtils() {
    }

    public static Object loadJsonFromFile(String filePath, Boolean isArray) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Cargar el archivo desde resources
        InputStream inputStream = JsonUtils.class.getResourceAsStream("/templates/" + filePath);

        if (inputStream == null) {
            throw new IOException("No se pudo encontrar el archivo: " + filePath);
        }
        // Detecta si el JSON es un array o un objeto
        if (isArray) {
            return objectMapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>() {
            });
        } else {
            return objectMapper.readValue(inputStream, new TypeReference<Map<String, Object>>() {
            });
        }
    }
}
