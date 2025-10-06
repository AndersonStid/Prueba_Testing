# 🧪 Automatización de APIs - OrangeHRM con Serenity BDD

## 📖 Introducción
Este proyecto corresponde a la **automatización de pruebas de APIs** del sistema **OrangeHRM**, utilizando **Serenity BDD**, **Gradle** y el **patrón Screenplay**.  
El objetivo fue validar diferentes escenarios de consulta y manejo de empleados mediante peticiones REST, generando reportes detallados en Serenity.  

La automatización incluye:
- Generación de **token OAuth 2.0**.
- Validación de **respuestas HTTP**.
- Comparación de **JSON esperados vs reales**.
- Reporte automático con **Serenity Reports**.

---

## ⚙️ Tecnologías utilizadas

| Herramienta | Versión / Descripción |
|--------------|-----------------------|
| **Java** | JDK 21 |
| **Gradle** | Manejador de dependencias |
| **Serenity BDD** | 4.1.10 |
| **Handlebars** | Motor de plantillas para manejo dinámico de JSON |
| **Maven Central** | Repositorio de dependencias |
| **Postman** | Generación y prueba del token OAuth 2.0 |
| **GitHub Actions** | Pipeline CI/CD para ejecución automática |

---

## 🧱 Estructura del proyecto

```
AUTOMATIZACION_APIS
│
├── .github/workflows/      # Pipeline CI/CD
├── src
│   ├── main/java/com.prueba.certificacion.api/
│   │   ├── exceptions/
│   │   ├── interactions/
│   │   ├── models/
│   │   ├── questions/
│   │   ├── tasks/
│   │   ├── userinterfaces/
│   │   └── utils/
│   └── test/
│       ├── java/
│       └── resources/
│           ├── features/
│           └── templates/
└── build.gradle
```

---

## 🚀 Configuración y ejecución

### Variables de entorno usadas
Durante la ejecución del pipeline (CI o local), se utilizan las siguientes propiedades del sistema:

```bash
-Dbase_url=https://opensource-demo.orangehrmlive.com/web/index.php
-Durl=/api/v2/pim/employees
-Durl_token=https://opensource-demo.orangehrmlive.com
-Durl_tokens=/web/index.php/auth/validate
-Dusername=Admin
-Dpassword=admin123
```

Estas variables permiten construir dinámicamente las peticiones HTTP.  
Sin embargo, debido a la complejidad del flujo de **OAuth 2.0**, se decidió **quemar el token** directamente en la automatización para garantizar estabilidad y reducir tiempos de ejecución.

---

## 🔐 Generación del Token OAuth 2.0

Se utilizó la documentación oficial de OrangeHRM:
📚 [https://api-starter-orangehrm.readme.io/reference/registering-a-client](https://api-starter-orangehrm.readme.io/reference/registering-a-client)

El token fue configurado mediante Postman con autenticación **OAuth 2.0**:
- **Grant Type:** Authorization Code (With PKCE)  
- **Header Prefix:** Bearer  
- **Auto-refresh token:** Activado  

Debido a que el proceso de OAuth 2.0 implica redirecciones y verificación manual, no se automatizó esta parte dentro del framework.

---

## 🧩 Escenarios Implementados

### 🧾 Feature: Generate token
```gherkin
Feature: Generate token

  Scenario: Generate Token
    When Generate Token
```

### 👥 Feature: Validate create employee
Se implementaron múltiples escenarios para validar el comportamiento de la API con y sin campos obligatorios.

Ejemplo:
```gherkin
Feature: Validate create employee

  Scenario: Validate employees
    When Load customer information
      | Authorization | limit | offset | model    | includeEmployees | sortField          | sortOrder |
      | Authorization | 4     | 0      | detailed | onlyCurrent      | employee.firstName | ASC       |
    When Load templates
    And Api response code 200
    Then Validate Json
```

También se validaron errores por ausencia de campos (`limit`, `offset`, `model`, `includeEmployees`, `sortField`, `sortOrder`), esperando código `422`.

---

## 🧠 Dificultades encontradas

La principal dificultad fue la **autenticación y generación del token OAuth 2.0**, ya que:
- Requería múltiples pasos manuales.
- No era práctico automatizar la obtención por tiempo y complejidad.
- Se optó por **usar un token estático** durante la ejecución de pruebas.

---

## 🏗️ Build.gradle

```gradle
plugins {
    id "net.serenity-bdd.serenity-gradle-plugin" version "4.0.46"
    id 'java'
    id 'jvm-test-suite'
    id 'eclipse'
    id 'idea'
}

defaultTasks 'clean', 'test', 'aggregate'

repositories {
    mavenCentral()
}

java {
    toolchain {
        def var = languageVersion = JavaLanguageVersion.of(21)
        var
    }
}

compileJava.options.encoding = "UTF-8"
compileTestJava.options.encoding = "UTF-8"

dependencies {
    implementation 'org.junit.jupiter:junit-jupiter-api:5.10.2'
    implementation 'net.serenity-bdd:serenity-core:4.1.10'
    implementation 'net.serenity-bdd:serenity-junit:4.1.10'
    implementation 'org.assertj:assertj-core:3.25.3'
    implementation 'net.serenity-bdd:serenity-cucumber:4.1.10'
    implementation 'net.serenity-bdd:serenity-screenplay:4.1.10'
    implementation 'net.serenity-bdd:serenity-screenplay-rest:4.1.10'
    implementation 'org.slf4j:slf4j-simple:2.0.13'
    implementation group: 'com.github.jknack', name: 'handlebars', version: '4.3.0'
    implementation group: 'org.json', name: 'json', version: '20230227'
}

gradle.startParameter.continueOnFailure = true

test {
    systemProperties System.getProperties()
    doFirst {
        delete 'target'
    }
    finalizedBy 'aggregate'
}
```

---

## 🧱 Patrón de diseño
El proyecto utiliza el patrón **Screenplay** de Serenity BDD, el cual:
- Facilita la **reutilización** de pasos.
- Separa la **lógica de negocio** de la implementación técnica.
- Mejora la **legibilidad** de los escenarios.

---

## 🧾 Reportes
Una vez ejecutadas las pruebas, Serenity genera automáticamente un reporte HTML:
```
AUTOMATIZACION_APIS/target/site/serenity/index.html
```

---

## 🧩 Pipeline de CI/CD
El pipeline está configurado en `.github/workflows/` y ejecuta automáticamente:
1. Compilación del proyecto.  
2. Ejecución de pruebas.  
3. Publicación del reporte Serenity como artefacto descargable.

---

## 🙌 Contribuciones
Para contribuir, puedes crear una rama y enviar un Pull Request con tus mejoras.

---

## 👨‍💻 Autor
**Anderson Medina**  
Prueba técnica para validación de pruebas automatizadas con **Serenity BDD + APIs**.
