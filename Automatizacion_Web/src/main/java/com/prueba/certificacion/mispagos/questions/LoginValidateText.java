package com.prueba.certificacion.mispagos.questions;


import com.prueba.certificacion.mispagos.exceptions.GenerateExceptions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.logging.Logger;


public class LoginValidateText implements Question<String> {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginValidateText.class));
    Target element;

    public LoginValidateText(Target element) {
        this.element = element;
    }

    public static LoginValidateText correct(Target element) {
        return new LoginValidateText(element);

    }

    @Override
    public String answeredBy(Actor actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isPresent()).forNoMoreThan(100).seconds()
                               );
                 }  catch (Exception e) {
                             throw new GenerateExceptions("The element is not present: " + element.getName(), e);
                   }

        String labelField = Text.of(element).answeredBy (actor).toString().split("\n")[0];
        LOGGER.info("The text found in the locator is: " + labelField);
        return labelField;
    }

}