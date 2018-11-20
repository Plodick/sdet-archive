package com.core.PageObjectModel.PageObjectsMethods;

import com.core.PageObjectModel.PageObjectsLocators.GoogleMailPageLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleMailPage extends GoogleMailPageLocators {

    public GoogleMailPage(WebDriver driver) {
        super(driver);
    }

    public void searchByLetters(String mail) // поиск по письмам
    {
        driver.findElement(mailSearchField).sendKeys(mail);
        driver.findElement(mailSearchField).sendKeys(Keys.ENTER);
    }

    public int getLetterCount() // число всех писем по текущим параметрам
    {
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) b ->
                b.getTitle().toLowerCase().startsWith("результаты"));
        List<WebElement> countList = driver.findElements(countLetter);
        return Integer.parseInt(countList.get(1).getText());
    }

    public void sendLetter(String mail, String subject, String text) { // отправка письма
        driver.findElement(writeButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(recipientMailField).sendKeys(mail);
        driver.findElement(subjectLetterField).sendKeys(subject);
        driver.findElement(textLetterField).sendKeys(text);
        driver.findElement(textLetterField).sendKeys(Keys.CONTROL, Keys.ENTER);
    }

    public boolean checkStatus() // проверка статуса отправки
    {
        return driver.findElement(messageStatus).isDisplayed();
    }
}
