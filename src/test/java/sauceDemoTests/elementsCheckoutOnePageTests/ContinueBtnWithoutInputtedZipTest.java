package sauceDemoTests.elementsCheckoutOnePageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class ContinueBtnWithoutInputtedZipTest {
    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "performance_glitch_user"})
    public void checkContinueBtnWithoutZip(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username, "secret_sauce")
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnOneCheckStepPage()
                .clickOnFirstNameArea()
                .setFirstName("Masha")
                .checkIsFirstNameInputted("Masha")
                .clickOnLastNameArea()
                .setLastName("Popova")
                .checkIsLastNameInputtedSuccessful("Popova")
                .clickOnContinueBtnWithoutZip()
                .checkClickOnContinueBtnWithoutZip()
                .checkErrorsElements()
                .checkURL("https://www.saucedemo.com/checkout-step-one.html");
    }
}
