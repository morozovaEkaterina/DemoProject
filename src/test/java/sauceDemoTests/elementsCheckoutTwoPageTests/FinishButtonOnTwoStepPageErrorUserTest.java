package sauceDemoTests.elementsCheckoutTwoPageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class FinishButtonOnTwoStepPageErrorUserTest {
    @ParameterizedTest
    @CsvSource(value = {
            "error_user"})
    public void checkClickOnFinishBtnTwoStepPage(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username, "secret_sauce")
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnOneCheckStepPage()
                .successfulInfoCheckout("Masha", "Popova", "6546451")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnFinishBtnCompletePageUnsuccessful()
                .checkURL("https://www.saucedemo.com/checkout-step-two.html");
    }
}


