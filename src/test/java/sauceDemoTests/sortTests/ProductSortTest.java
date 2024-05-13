package sauceDemoTests.sortTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class ProductSortTest {

    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "performance_glitch_user"})
    public void checkSortProductForStandardVisualGlitchUsers(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username,"secret_sauce")
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnProductPage()
                .clickOnSortBtn()
                .checkSortMenu()
                .checkAZName()
                .checkZAName()
                .checkPriceLowToHigh()
                .checkPriceHighToLow();
    }
}
