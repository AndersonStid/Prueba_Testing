# Proyecto de Pruebas Automatizadas Web

Este proyecto contiene pruebas automatizadas de API y Web desarrolladas con Serenity BDD bajo el patrón Screenplay.

## 🧩 Estructura del Proyecto

```
/src
 ├── main
 │   └── java
 │       └── com.banistmo.certification
 │            ├── interactions
 │            ├── models
 │            ├── tasks
 │            ├── utils
 │            └── questions
 └── test
     └── java
         └── com.banistmo.certification.runners
```

## 🚀 Cambios recientes

### 🌐 Pruebas Web
- Se actualizaron los `Tasks` para manejar cambios de idioma y eliminación de usuarios.
- Se agregaron pasos condicionales para detección de idioma de la interfaz (Español/Inglés/etc..).
- Implementación de nuevas validaciones visuales con Serenity Reports.
- Capturas de pantalla habilitadas `FOR_EACH_ACTION` para mayor trazabilidad.

## ⚙️ Configuración del Proyecto

### Requisitos
- Java 21 o superior
- Gradle 8+
- Serenity BDD 4.1.10
- Navegador Chrome (versión estable)
- Git y GitHub configurados

### Generar Reporte
```bash
gradle aggregate
```

El reporte estará disponible en:
```
target/site/serenity/index.html
```

## 👥 Colaboradores
- QA Automation: Anderson Medina
- Framework base: Serenity BDD + Screenplay Pattern
- Gestión de versiones: GitHub

