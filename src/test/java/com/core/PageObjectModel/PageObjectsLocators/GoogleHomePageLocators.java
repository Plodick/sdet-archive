package com.core.PageObjectModel.PageObjectsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePageLocators
{
    protected WebDriver driver;

    protected By searchField = By.id("lst-ib"); // поле поиска

    protected By loginButton = By.id("gb_70"); // кнопка "Войти"

    protected By mailButton = By.className("gb_P"); // кнопка "Почта"

    public GoogleHomePageLocators(WebDriver driver) { // конструктор класса страницы
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


}