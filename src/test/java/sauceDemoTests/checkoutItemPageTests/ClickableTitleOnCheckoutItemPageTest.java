package sauceDemoTests.checkoutItemPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Check click on item`s title on the checkout item page ")
public class ClickableTitleOnCheckoutItemPageTest extends BaseTest {

    @DisplayName("Check click on item`s title ")
    @Test
    public void checkClickableTitleOnCheckoutItemPage() {
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
                .checkItemInfo()
                .clickOnItemsTitle("Sauce Labs Bike Light")
                .checkIsItemTheSame("Sauce Labs Bike Light");
    }
}