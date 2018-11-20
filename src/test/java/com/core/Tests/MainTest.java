package com.core.Tests;

import com.core.BaseTestGrid;
import com.core.PageObjectModel.PageObjectsMethods.GoogleHomePage;
import com.core.PageObjectModel.PageObjectsMethods.GoogleMailPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTestGrid {

    private String login;
    private String password;
    private String surname;
    private String recipientMail;

    private WebDriver commonDriver;
    private GoogleHomePage homePage;

    @Test(description = "Инициализация.", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void initDriver() {
        // Загрузка данных из config.properties
        login = property.getProperty("login");
        password = property.getProperty("password");
        surname = property.getProperty("surname");
        recipientMail = property.getProperty("mail");
        commonDriver = getDriver();
    }

    @Test(description = "Запуск браузера и открытие стартовой страницы.", priority = 2)
    public void launchGoogle() {
        commonDriver.get("http://google.com");
    }

    @Test(description = "Авторизация в Google.", priority = 3)
    public void loginGmail() {
        homePage = new GoogleHomePage(commonDriver);
        homePage.loginUser(login, password);
    }

    @Test(description = "Переход на почту и отправка письма", priority = 4)
    public void sendLetter() {
        GoogleMailPage mailPage = homePage.goToMail();
        mailPage.searchByLetters("in:inbox " + recipientMail);
        int letterCount = mailPage.getLetterCount();
        String subject = "Tестовое задание. " + surname;
        mailPage.sendLetter(recipientMail, subject, "Количество писем: " + Integer.toString(letterCount));
        Assert.assertTrue(mailPage.checkStatus());
    }

}
