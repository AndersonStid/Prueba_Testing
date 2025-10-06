package com.prueba.certificacion.mispagos.interaction;

import com.prueba.certificacion.mispagos.questions.TargetAWebQuestion;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.io.File;
import static com.prueba.certificacion.mispagos.utils.Constants.REMEMBER_DATA_RADENTRADA;

public class SubirArchivoInteraction extends PageObject implements Interaction {
    String nombreArchivo;
    Target element;

    public SubirArchivoInteraction(String nombreArchivo, Target element) {
        this.nombreArchivo = nombreArchivo;
        this.element = element;
    }

    public static SubirArchivoInteraction subirArchivoInteraction(String nombreArchivo, Target element) {
        return new SubirArchivoInteraction(nombreArchivo, element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String ruta = REMEMBER_DATA_RADENTRADA.getConstant() + nombreArchivo ;

        File file = new File(ruta);
        String path = file.getAbsolutePath();
        WebElement archivo = actor.asksFor(TargetAWebQuestion.conTarget(element));
        evaluateJavascript("arguments[0].style.display = 'block';", archivo);

        archivo.sendKeys(path);

    }
}
