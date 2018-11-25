package com.selenium.helpers;

import com.selenium.objects.Config;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by selcuk.ayhan on 15.01.2018
 */
public class BaseTest {

    public WebDriver driver;

    @Before
    public void startUp() {
        driver = new ChromeDriver();
        System.out.println(driver);
        driver.get(Config.MAIN_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
