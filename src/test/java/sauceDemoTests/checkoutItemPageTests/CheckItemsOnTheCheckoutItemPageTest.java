package sauceDemoTests.checkoutItemPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Check that items on the checkout item page like on the cart page")
public class CheckItemsOnTheCheckoutItemPageTest extends BaseTest {

    @DisplayName("Check that items on the checkout item page like  on the cart page")
    @Test
    public void checkItemTheSameLikeInCartTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnAddToCartBtn("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light")
                .checkClickOnAddToCartBtn()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("Anna", "Koroleva", "AS45")
                .clickOnContinueBtnSuccessful()
                .checkItemInfo();
    }
}
