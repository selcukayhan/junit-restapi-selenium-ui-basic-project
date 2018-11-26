package com.selenium;

import com.selenium.helpers.BaseTest;
import com.selenium.objects.Buyer;
import com.selenium.pages.FavoritesPage;
import com.selenium.pages.HomePage;
import com.selenium.pages.PaymentConfirmationPage;
import org.junit.Test;

import static com.selenium.objects.BuyerPool.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SmokeTest extends BaseTest {

    @Test
    public void shouldLogin() {
        Buyer buyer = buyerForLoginTest(driver)
                .login();

        assertThat("Buyer is logged in!", new HomePage(driver).isLoggedIn(buyer));
    }

    @Test
    public void shouldNotLogin() {
        Buyer buyer = buyerForInvalidLoginTest(driver)
                .login();

        assertThat("Buyer is not logged in!", !new HomePage(driver).isLoggedIn(buyer));
    }

    @Test
    public void shouldAddToFavorites() {
        FavoritesPage favoritesPage = buyerForFavoritesTest(driver)
                .login()
                .clearMyFavorites();

        String productName = favoritesPage.search("kalem")
                .addToFavorites(1);
        favoritesPage.goToFavorites();

        assertThat(productName, equalTo(favoritesPage.getProductName(1)));
    }

    @Test
    public void shouldSeeWarningsOnPaymentPage() {
        buyerForLoginTest(driver)
                .login()
                .search("Casio MTP-1374D-7AVDF")
                .clickProduct(1)
                .instantPay()
                .acceptAgreement()
                .purchase();

        PaymentConfirmationPage paymentConfirmationPage = new PaymentConfirmationPage(driver);
        assertThat("Warning is not displaying!", !paymentConfirmationPage.isWarningDisplayedFor("cardNumber"));
        assertThat("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("holderName"));
        assertThat("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("expireMonth"));
        assertThat("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("securityCode"));
    }
}
