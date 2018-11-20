package com.core.PageObjectModel.PageObjectsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleAuthorizationPageLocators {

    protected WebDriver driver;

    protected By loginField = By.id("identifierId"); // поле для логина

    protected By passwordField = By.xpath("//input[@name='password']"); // поле для пароля

    public GoogleAuthorizationPageLocators(WebDriver driver) { // конструктор класса страницы
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
