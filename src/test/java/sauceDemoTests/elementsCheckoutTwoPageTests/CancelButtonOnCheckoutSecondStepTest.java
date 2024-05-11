package sauceDemoTests.elementsCheckoutTwoPageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.stepsPackage.LoginPageSteps;

public class CancelButtonOnCheckoutSecondStepTest {

    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "error_user",
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
                .successfulInfoCheckout("kola", "kola", "dsp;ck")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnCancelBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }
}
