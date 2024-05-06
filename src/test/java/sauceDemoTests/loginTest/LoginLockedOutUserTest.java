package sauceDemoTests.loginTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.SauceDemoMainSteps;

public class LoginLockedOutUserTest {
    @ParameterizedTest
    @CsvSource(value = {
            "locked_out_user"})
    public void loginLockedOutUserTest(String username) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        Configuration.browserCapabilities = chromeOptions;
        SauceDemoMainSteps.open("https://www.saucedemo.com/")
                .checkStaticElements()
                .clickOnUsernameArea()
                .setUsername(username)
                .clickOnPasswordArea()
                .setPassword("secret_sauce")
                .clickOnLoginBtnUnsuccessful()
                .checkURL("https://www.saucedemo.com/")
                .checkStaticElements()
                .checkErrorElements();
    }
}
