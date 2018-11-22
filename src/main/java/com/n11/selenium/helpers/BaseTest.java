package com.n11.selenium.helpers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.n11.selenium.objects.Config.MAIN_URL;

/**
 * Created by selcuk.ayhan on 15.01.2018
 */
public class BaseTest {

    public WebDriver driver;

    @Before
    public void startUp() {
        driver = new ChromeDriver();
        System.out.println(driver);
        driver.get(MAIN_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
