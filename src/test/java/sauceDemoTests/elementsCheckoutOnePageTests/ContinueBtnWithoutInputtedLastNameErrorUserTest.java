package sauceDemoTests.elementsCheckoutOnePageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class ContinueBtnWithoutInputtedLastNameErrorUserTest {

    @ParameterizedTest
    @CsvSource(value = {
            "error_user"})
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
                .checkURL("https://www.saucedemo.com/checkout-step-two.html");
    }
}

