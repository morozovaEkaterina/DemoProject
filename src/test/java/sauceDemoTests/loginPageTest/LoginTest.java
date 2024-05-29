package sauceDemoTests.loginPageTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on login")

public class LoginTest extends BaseTest {
    @DisplayName("Check successful login on website")
    @Test
    public void loginSuccessfulTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage();
    }

    @DisplayName("Check  login on website without inputted passwordS or without filling out two fields")
    @Test
    public void loginWithoutPasswordTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .clickOnUsernameArea()
                .setUsername(usernameS)
                .clickOnLoginBtnUnsuccessful()
                .checkErrorElementsWithoutPassword();
    }

    @DisplayName("Check  login on website without inputted usernameS")
    @Test
    public void loginWithoutUsernameTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .clickOnUsernameArea()
                .clickOnPasswordArea()
                .setPassword(passwordS)
                .clickOnLoginBtnUnsuccessful()
                .checkErrorElementsWithoutUsername();
    }

    @DisplayName("Check  login on website with wrong inputted passwordS or usernameS")
    @Test
    public void loginWithWrongInputtedTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(passwordS, passwordS)
                .clickOnLoginBtnUnsuccessful()
                .checkErrorElementsWithWrongInputted();
    }
}

