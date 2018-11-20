package com.core.PageObjectModel.PageObjectsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMailPageLocators {

    protected WebDriver driver;

    protected By mailSearchField = By.xpath("//input[@placeholder=\"Поиск в почте\"]"); //поле поиска писем

    protected By writeButton = By.xpath("//*[contains(text(),'Написать')]"); // кнопка "Написать"

    protected By subjectLetterField = By.xpath("//input[@name='subjectbox']"); // поле темы письма

    protected By recipientMailField = By.xpath("//textarea[@aria-label='Кому']"); // поле почты получателя

    protected By textLetterField = By.xpath("//div[@aria-label='Тело письма']"); // поле текста письма

    protected By messageStatus = By.xpath("//*[contains(text(),'Письмо отправлено.')]"); // всплывающее сообщение об отправленном сообщении

    protected By countLetter = By.xpath("//span[@class='Dj']/span[2]"); // локатор для значения количества найденных писем

    public GoogleMailPageLocators(WebDriver driver) { // конструктор класса страницы
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
