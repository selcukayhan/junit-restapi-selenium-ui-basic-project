package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(id = "instantPay")
    private WebElement instantPayButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public PaymentConfirmationPage instantPay() {
        clickTo(instantPayButton);
        return new PaymentConfirmationPage(driver);
    }
}
