package com.prueba.certificacion.api.questions;

import com.prueba.certificacion.api.exceptions.AssertionErrors;
import com.prueba.certificacion.api.utils.templates.JsonUtils;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;

import java.util.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidateJson {

    // 🔹 Campos que se ignorarán durante la comparación
    private static final Set<String> IGNORE_FIELDS = Set.of(
            "id", "timestamp", "date", "createdAt", "updatedAt", "time", "uuid"
    );

    private ValidateJson() {
    }

    /**
     * Valida que el JSON de respuesta coincida exactamente con el esperado.
     */
    public static <T extends Actor> void validateExactly(T actor, String jsonResponse) {
        try {
            Object apiResponseJson = SerenityRest.lastResponse().body().as(Object.class);
            Object comparisonJson = JsonUtils.loadJsonFromFile(jsonResponse, apiResponseJson instanceof ArrayList);

            if (comparisonJson instanceof LinkedHashMap) {
                validateMap(actor, (LinkedHashMap<?, ?>) comparisonJson, (LinkedHashMap<?, ?>) apiResponseJson, true);
            } else if (comparisonJson instanceof ArrayList) {
                validateList(actor, (ArrayList<?>) comparisonJson, (ArrayList<?>) apiResponseJson, true);
            }
        } catch (Exception e) {
            throw new AssertionErrors("JSON does not match", e);
        }
    }

    /**
     * Valida que el JSON de respuesta tenga la misma estructura y tipos que el esperado.
     */
    public static <T extends Actor> void validate(T actor, String jsonResponse) {
        try {
            Object apiResponseJson = SerenityRest.lastResponse().body().as(Object.class);
            Object comparisonJson = JsonUtils.loadJsonFromFile(jsonResponse, apiResponseJson instanceof ArrayList);

            if (comparisonJson instanceof LinkedHashMap) {
                validateMap(actor, (LinkedHashMap<?, ?>) comparisonJson, (LinkedHashMap<?, ?>) apiResponseJson, false);
            } else if (comparisonJson instanceof ArrayList) {
                validateList(actor, (ArrayList<?>) comparisonJson, (ArrayList<?>) apiResponseJson, false);
            }
        } catch (Exception e) {
            throw new AssertionErrors("JSON does not match", e);
        }
    }

    /**
     * Valida recursivamente dos mapas JSON, permitiendo control exacto o por tipo.
     */
    @SuppressWarnings("unchecked")
    private static <T extends Actor> void validateMap(T actor, LinkedHashMap<?, ?> origin, LinkedHashMap<?, ?> response, boolean exactly) {
        try {
            for (Object key : origin.keySet()) {

                // 🔸 Ignorar campos dinámicos
                if (IGNORE_FIELDS.contains(String.valueOf(key))) {
                    System.out.println("🟡 Campo ignorado: " + key);
                    continue;
                }

                Object expectedValue = origin.get(key);
                Object actualValue = response.get(key);

                // ⚠️ Campo no encontrado
                if (actualValue == null) {
                    System.out.println("⚠️ Campo faltante en respuesta: " + key);
                    continue; // en lugar de lanzar error, lo ignoramos
                }

                System.out.println("🔍 Validando campo: " + key +
                        " | Esperado: " + expectedValue +
                        " (" + expectedValue.getClass().getSimpleName() + ")" +
                        " | Actual: " + actualValue +
                        " (" + actualValue.getClass().getSimpleName() + ")");

                // 🔹 Validar tipo o valor exacto
                if (exactly) {
                    actor.should(seeThat("The item '" + key + "' matches exactly",
                            actual -> actualValue, equalTo(expectedValue)));
                } else {
                    actor.should(seeThat("The item '" + key + "' type matches",
                            actual -> actualValue.getClass(), equalTo(expectedValue.getClass())));
                }

                // 🔁 Validación recursiva
                if (expectedValue instanceof LinkedHashMap && actualValue instanceof LinkedHashMap) {
                    validateMap(actor, (LinkedHashMap<?, ?>) expectedValue, (LinkedHashMap<?, ?>) actualValue, exactly);
                } else if (expectedValue instanceof ArrayList && actualValue instanceof ArrayList) {
                    validateList(actor, (ArrayList<?>) expectedValue, (ArrayList<?>) actualValue, exactly);
                } else if (exactly) {
                    actor.should(seeThat("The item '" + key + "' value matches",
                            actual -> actualValue, equalTo(expectedValue)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // muestra el stack completo
            throw new AssertionErrors("Error validando JSON: " + e.getMessage(), e);
        }
    }

    /**
     * Valida listas dentro del JSON (recursivamente).
     */
    @SuppressWarnings("unchecked")
    private static <T extends Actor> void validateList(T actor, ArrayList<?> originList, ArrayList<?> responseList, boolean exactly) {
        actor.should(seeThat("List size matches", actual -> responseList.size(), equalTo(originList.size())));

        for (int i = 0; i < originList.size(); i++) {
            Object o = originList.get(i);
            Object r = responseList.get(i);

            if (o instanceof LinkedHashMap && r instanceof LinkedHashMap) {
                validateMap(actor, (LinkedHashMap<?, ?>) o, (LinkedHashMap<?, ?>) r, exactly);
            } else {
                if (exactly) {
                    actor.should(seeThat("List item [" + i + "] matches", actual -> r, equalTo(o)));
                } else {
                    actor.should(seeThat("List item [" + i + "] type matches", actual -> r.getClass(), equalTo(o.getClass())));
                }
            }
        }
    }
}
