package com.prueba.certificacion.mispagos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login {
    public static final Target TXT_USER = Target.the("Text field User").
            located(By.xpath("//input[@name='username']"));
    public static final Target TXT_PASSWAORD = Target.the("Text field User").
            located(By.xpath("//input[@name='password']"));
    public static final Target BTN_GET_INTO = Target.the("Enter button").
            located(By.xpath("//button[@type='submit']"));
    public static final Target TEXT_VALIDATE = Target.the("Compare text").
            located(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div/p"));
    public static final Target BTN_PIM = Target.the("Compare text").
            located(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
    public static final Target BTN_EDIT = Target.the("Compare text").
            located(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]"));
    public static final Target BTN_FIRSTNAME = Target.the("Compare text").
            located(By.xpath("//input[@name='firstName']"));

    public static final Target BTN_MIDDLENAME = Target.the("Compare text").
            located(By.xpath("//input[@name='middleName']"));

    public static final Target BTN_LASTNAME = Target.the("Compare text").
            located(By.xpath("//input[@name='lastName']"));

    public static final Target BTN_EMPLOYEEID = Target.the("Compare text").
            located(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
    public static final Target BTN_SELECCIONAR_ARCHIVO= Target.the("Agregar Archivo").
            located(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/input"));
    public static final Target BTN_CREAR_DOC_DIGITAL= Target.the("Boton Crear Doc Digital").
            located(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button"));
    public static final Target BTN_SAVE= Target.the("Boton Crear Doc Digital").
            located(By.xpath("//button[@type='submit']"));
    public static final Target TEXT_VALIDATE_EMPLOYEED= Target.the("Boton Crear Doc Digital").
            located(By.xpath("//*/text()[normalize-space(.)='Anderson Narajos']/parent::*"));

    private Login() {
    }
}
