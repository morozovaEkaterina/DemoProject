package sauceDemoTests.elementsOnProductPageTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.stepsPackage.LoginPageSteps;

public class AddToCartBtnPageTest {

    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "problem_user",
            "error_user",
            "performance_glitch_user"})
    public void addToCartTest(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username,"secret_sauce")
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnAddBtn(3)
                .clickOnAddBtn(0)
                .clickOnRemoveBtn(0)
                .clickOnRemoveBtn(3);
    }
}
