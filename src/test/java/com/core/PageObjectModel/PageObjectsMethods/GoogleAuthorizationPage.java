package com.core.PageObjectModel.PageObjectsMethods;

import com.core.PageObjectModel.PageObjectsLocators.GoogleAuthorizationPageLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class GoogleAuthorizationPage extends GoogleAuthorizationPageLocators {

    public GoogleAuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public GoogleHomePage loginUser(String login, String password) // авторизация пользователя
    {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(loginField).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
        return new GoogleHomePage(driver);
    }
}
