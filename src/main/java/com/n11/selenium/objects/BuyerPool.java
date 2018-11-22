package com.n11.selenium.objects;

import org.openqa.selenium.WebDriver;

import static com.n11.selenium.objects.Config.*;

/**
 * Created by selcuk.ayhan on 17.01.2018
 */
public class BuyerPool {

    private BuyerPool() {
    }

    public static Buyer buyerForLoginTest(WebDriver driver) {
        return new Buyer("slckayhn@gmail.com", DEFAULT_PASSWORD, DEFAULT_USERNAME, driver);
    }

    public static Buyer buyerForFavoritesTest(WebDriver driver) {
        return new Buyer("buyer@email.com", DEFAULT_PASSWORD, DEFAULT_USERNAME, driver);
    }

    public static Buyer buyerForInvalidLoginTest(WebDriver driver) {
        return new Buyer("buyer@email.com", INVALID_PASSWORD, DEFAULT_USERNAME, driver);
    }
}
