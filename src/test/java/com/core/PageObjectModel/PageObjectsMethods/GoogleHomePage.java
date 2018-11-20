package com.core.PageObjectModel.PageObjectsMethods;

import com.core.PageObjectModel.PageObjectsLocators.GoogleHomePageLocators;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends GoogleHomePageLocators {
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String text) { // поиск в Google
        driver.findElement(searchField).sendKeys(text);
        driver.findElement(searchField).submit();
    }

    public GoogleHomePage loginUser(String login, String password) // авторизация
    {
        driver.findElement(loginButton).click();
        return new GoogleAuthorizationPage(driver).loginUser(login,password);
    }

    public GoogleMailPage goToMail() // переход на страницу почты
    {
        driver.findElement(mailButton).click();
        return new GoogleMailPage(driver);
    }
}
