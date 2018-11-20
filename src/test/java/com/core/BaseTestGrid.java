package com.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

public class BaseTestGrid {

    protected FileInputStream fis;
    protected Properties property;

    protected String hubURL;
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @Parameters(value={"browser"})
    @BeforeClass(description = "Конфигурирование драйвера перед тестами")
    public void setupTest (@Optional("browser") String browser) throws MalformedURLException {
        try {
            fis = new FileInputStream(new File("src/test/resources/config.properties"));
            property = new Properties();
            property.load(new InputStreamReader(fis, Charset.forName("windows-1251")));
            hubURL = property.getProperty("hub");
        }
        catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        if (browser.equals("chrome"))
        {
            driver.set(new RemoteWebDriver(new URL(hubURL), new ChromeOptions()));
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterClass(description = "Выключение драйвера после тестов.")
    public void tearDown()  {
        getDriver().quit();
    }

    @AfterClass void terminate () {
        driver.remove();
    }
}
