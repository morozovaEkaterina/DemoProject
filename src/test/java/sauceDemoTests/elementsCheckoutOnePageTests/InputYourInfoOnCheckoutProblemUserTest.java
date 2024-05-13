package sauceDemoTests.elementsCheckoutOnePageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class InputYourInfoOnCheckoutProblemUserTest {

    @ParameterizedTest
    @CsvSource(value = {"problem_user"
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
                .setFirstName("Masha")
                .checkIsFirstNameInputted("Masha")
                .clickOnLastNameArea()
                .setLastName("Popova")
                .checkIsLastNameInputtedUnsuccessful("Popova")
                .clickOnZipArea()
                .setZip("498450")
                .checkIsZipInputted("498450")
                .clickOnContinueBtnUnsuccessful()
                .checkURL("https://www.saucedemo.com/checkout-step-one.html");
    }
}


