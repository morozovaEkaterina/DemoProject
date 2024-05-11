package sauceDemoTests.loginTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.stepsPackage.LoginPageSteps;

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
