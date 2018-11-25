package com.selenium.pages;

import com.selenium.helpers.PageUtils;
import com.selenium.objects.Buyer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.selenium.objects.Config.MAIN_URL;

/**
 * Created by selcuk.ayhan on 15.01.2018
 */
public class BasePage extends Page {

    @FindBy(className = "btnSignIn")
    private WebElement signInButton;

    @FindBy(id = "searchData")
    private WebElement searchBar;

    @FindBy(className = "searchBtn")
    private WebElement searchButton;

    @FindBy(css = "a.menuLink.user")
    private WebElement username;

    @FindBy(xpath = "//*[@title='Hesabım']")
    private WebElement myAccount;

    @FindBy(xpath = "//*[@title='Favorilerim']")
    private WebElement myFavorites;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage callLoginPage() {
        clickTo(signInButton);
        return new LoginPage(driver);
    }

    public SearchResultPage search(String keyword) {
        typeTo(searchBar, keyword);
        clickTo(searchButton);
        return new SearchResultPage(driver);
    }

    public boolean isLoggedIn(Buyer buyer) {
        if (getCurrentUrl().equals(MAIN_URL) && isElementPresent(username)) {
            String userNameOnPage = getText(username);
            return userNameOnPage.equals(buyer.getName());
        } else {
            return false;
        }
    }

    public BasePage openMyAccountMenu() {
        moveTo(myAccount);
        return this;
    }

    public BasePage clickToMyPageOf(String elementName) {
        PageUtils utils = new PageUtils();
        clickTo(utils.get(elementName, this));
        return this;
    }
}
