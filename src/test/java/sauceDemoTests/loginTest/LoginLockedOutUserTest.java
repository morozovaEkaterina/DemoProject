package sauceDemoTests.loginTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemo.steps.LoginPageSteps;

public class LoginLockedOutUserTest {
    @ParameterizedTest
    @CsvSource(value = {
            "locked_out_user"})
    public void loginLockedOutUserTest(String username) {
        LoginPageSteps.open("https://www.saucedemo.com/")
                .waitPageLoading()
                .successfulLogin(username,"secret_sauce")
                .clickOnLoginBtnUnsuccessful()
                .checkURL("https://www.saucedemo.com/")
                .waitPageLoading()
                .checkErrorElements();
    }
}
