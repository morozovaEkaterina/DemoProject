package sauceDemoTest.sauceDemoLoginTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemoLogin.BasePage;
import sauceDemoLogin.SauceDemoMainPage;

public class LoginLockedOutUserTest extends BasePage {

    @ParameterizedTest
    @CsvSource(value = {
            "locked_out_user"})
    public void lockedOutUserTest(String username) {
        SauceDemoMainPage.open("https://www.saucedemo.com/")
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
