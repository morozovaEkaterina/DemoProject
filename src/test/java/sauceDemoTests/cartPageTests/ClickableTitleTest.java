package sauceDemoTests.cartPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on clickable title on the cart page")
public class ClickableTitleTest extends BaseTest {

    @DisplayName("Check clickable title on the cart page")
    @Test
    public void checkClickableTitleTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnAddToCartBtn("Sauce Labs Onesie")
                .checkClickOnAddToCartBtn()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .checkIsItemsTheSame("Sauce Labs Onesie")
                .clickOnItemsTitle("Sauce Labs Onesie")
                .checkStaticElemsOnIndividualItemPage()
                .checkIsItemTheSame("Sauce Labs Onesie")
                .checkClickOnRemoveBtn();
    }
}

