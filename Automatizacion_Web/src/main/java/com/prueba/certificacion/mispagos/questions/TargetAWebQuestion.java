package com.prueba.certificacion.mispagos.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class TargetAWebQuestion implements Question<WebElement> {
    private final Target target;

    public TargetAWebQuestion(Target target) {
        this.target = target;
    }

    public static TargetAWebQuestion conTarget(Target target) {
        return new TargetAWebQuestion(target);
    }

    @Override
    public WebElement answeredBy(Actor actor) {
        return target.resolveFor(actor);
    }
}
