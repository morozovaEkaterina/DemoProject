package sauceDemoTests.elementsCheckoutTwoPageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.stepsPackage.LoginPageSteps;

public class FinishButtonOnTwoStepPageTest {
    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "error_user",
            "performance_glitch_user"})
    public void checkClickOnFinishBtnTwoStepPage(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username, "secret_sauce")
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnOneCheckStepPage()
                .successfulInfoCheckout("Anna", "Novikova", "564151")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnFinishBtnCompletePageSuccessful()
                .checkURL("https://www.saucedemo.com/checkout-complete.html");
    }
}
