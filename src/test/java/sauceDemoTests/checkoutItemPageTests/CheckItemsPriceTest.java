package sauceDemoTests.checkoutItemPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Check item price and total price on the checkout item page")
public class CheckItemsPriceTest extends BaseTest {

    @DisplayName("Check item total price ")
    @Test
    public void checkItemTotalPrice() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnAddToCartBtn("Sauce Labs Fleece Jacket", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light")
                .checkClickOnAddToCartBtn()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .checkIsItemsTheSame("Sauce Labs Fleece Jacket", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light")
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("kola", "kola", "dsp;ck")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .checkItemTotalPrice();
    }

    @DisplayName("Check total price ")
    @Test
    public void checkTotalPrice() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnAddToCartBtn("Sauce Labs Fleece Jacket", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light")
                .checkClickOnAddToCartBtn()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .checkIsItemsTheSame("Sauce Labs Fleece Jacket", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light")
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("kola", "kola", "dsp;ck")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .checkTotalPrice();
    }
}