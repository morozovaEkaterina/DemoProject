package sauceDemoTests.elementsCheckoutOnePageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.stepsPackage.LoginPageSteps;

public class InputYourInfoOnCheckoutProblemUserTest {

    @ParameterizedTest
    @CsvSource(value = {"problem_user"})
    public void inputInfoOnCheckoutFields(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username, "secret_sauce")
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnOneCheckStepPage()
                .successfulInfoCheckout("Lola", "fo", "fvflj")
                .clickOnContinueBtnUnsuccessful()
                .checkURL("https://www.saucedemo.com/checkout-step-one.html");
    }
}


