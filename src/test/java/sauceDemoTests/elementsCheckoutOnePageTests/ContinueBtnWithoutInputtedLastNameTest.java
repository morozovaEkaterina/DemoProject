package sauceDemoTests.elementsCheckoutOnePageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class ContinueBtnWithoutInputtedLastNameTest {
    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "performance_glitch_user"})
    public void checkContinueBtnWithoutLastName(String username) {
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
                .clickOnZipArea()
                .setZip("cv784")
                .checkIsZipInputted("cv784")
                .clickOnContinueBtnWithoutLastName()
                .checkClickOnContinueBtnWithoutLastName()
                .checkErrorsElements()
                .checkURL("https://www.saucedemo.com/checkout-step-one.html");
    }
}

