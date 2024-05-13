package sauceDemoTests.elementsCheckoutOnePageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class ContinueBtnWithoutInputtedZipErrorUserTest {
    @ParameterizedTest
    @CsvSource(value = {
            "error_user"})
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
                .checkIsLastNameInputtedUnsuccessful("Popova")
                .clickOnContinueBtnWithoutZip()
                .checkClickOnContinueBtnWithoutZip()
                .checkErrorsElements()
                .checkURL("https://www.saucedemo.com/checkout-step-one.html");
    }
}


