package sauceDemoTests.elementsCheckoutTwoPageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class CancelButtonOnCheckoutSecondStepErrorUserTest {
    @ParameterizedTest
    @CsvSource(value = {
            "error_user"})
    public void checkInputInfoOnCheckoutPage(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username, "secret_sauce")
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnOneCheckStepPage()
                .unSuccessfulInfoCheckoutForErrorUser("Olga","Ivanova","fk789")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnCancelBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }
}


