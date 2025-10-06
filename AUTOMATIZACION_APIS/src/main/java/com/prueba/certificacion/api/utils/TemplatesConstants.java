package com.prueba.certificacion.api.utils;

public enum TemplatesConstants {


    PATH_TEMPLATES("/templates"),
    TOKEN_JSON("get/token.json"),
    RESPONSE_JSON_EXIT("post/ValidateJson.json"),
    VALIDATEERRSORORDER("get/ValidateErrorsortOrder.json"),
    VALIDATEERRORLIMIT("post/ValidateErrorlimit.json"),
    VALIDATEERRORSORTFIELD("get/ValidateErrorsortField.json"),
    VALIDATEERROROFFSET("get/ValidateErroroffset.json"),
    VALIDATEERRORMODEL("get/ValidateErrormodel.json"),
    VALIDATEERRORINCLUDEEMPLOYEES("get/ValidateErrorincludeEmployees.json"),
    VALIDATEJSONCORRECT("get/ValidateJsonCorrect.json"),
    ;
    private final String templatePaths;

    TemplatesConstants(String templatePaths) {
        this.templatePaths = templatePaths;
    }

    public String getTemplatePaths() {
        return templatePaths;
    }
}
