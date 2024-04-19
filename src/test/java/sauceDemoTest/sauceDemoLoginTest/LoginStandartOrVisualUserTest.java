package sauceDemoTest.sauceDemoLoginTest;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sauceDemoLogin.BasePage;
import sauceDemoLogin.SauceDemoMainPage;

public class LoginStandartOrVisualUserTest extends BasePage {

    @Test
    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "problem_user",
            "error_user",
            "performance_glitch_user"})
    public void testStandardOrVisualUser(String username) {
        SauceDemoMainPage.open("https://www.saucedemo.com")
                .checkStaticElements()
                .clickOnUsernameArea()
                .setUsername(username)
                .clickOnPasswordArea()
                .setPassword("secret_sauce")
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnProductPage();
    }
}
