package sauceDemoTests.elementsCheckoutOnePageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class InputYourInfoOnCheckoutErrorUserTest {
    @ParameterizedTest
    @CsvSource(value = {"error_user"
    })
    public void inputInfoOnCheckoutFields(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username, "secret_sauce")
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnOneCheckStepPage()
                .clickOnFirstNameArea()
                .unSuccessfulInfoCheckoutForErrorUser("Masha", "Popova", "5HG454")
                .clickOnContinueBtnSuccessful()
                .checkURL("https://www.saucedemo.com/checkout-step-two.html");
    }
}



