package sauceDemoTests.wrapMenuTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class AllItemsTest {
    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "problem_user",
            "error_user",
            "performance_glitch_user"})
    public void checkAllItemsBtn(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username,"secret_sauce")
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnProductPage()
                .clickOnWrapMenu()
                .clickOnAllItemsBtn(0)
                .checkURL("https://www.saucedemo.com/inventory.html");
    }
}
