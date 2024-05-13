package sauceDemoTests.elementsCheckoutOnePageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class InputYouInfoOnCheckoutPageTest {
    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "performance_glitch_user"})
    public void checkInputInfoOnCheckoutPage(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username, "secret_sauce")
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnOneCheckStepPage()
                .successfulInfoCheckout("Masha", "Ol", "dfk56")
                .clickOnContinueBtnSuccessful()
                .checkURL("https://www.saucedemo.com/checkout-step-two.html");
    }
}
