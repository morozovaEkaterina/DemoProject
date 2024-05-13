package sauceDemoTests.elementsOnProductPageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class AddToCartBtnProblemErrorUsersTest {
    @ParameterizedTest
    @CsvSource(value = {"problem_user",
            "error_user"})
    public void addToCartUnsuccessfulTest(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username, "secret_sauce")
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnAddBtnUnsuccessful()
                .checkClickOnAddBtnUnsuccessful()
                .clickOnWrapMenu()
                .clickOnResetAppStateBtn();
    }
}


