package sauceDemoTests.wrapMenuTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Test on close(cross) button wrap menu ")
public class CloseWrapMenuBtnTest extends BaseTest {

    @DisplayName("Check close(cross) button wrap menu")
    @Test
    public void checkCloseMenuBtn() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnWrapMenu()
                .clickOnCloseWrapMenuBtn()
                .checkClickOnCloseWrapMenuBtn();
    }
}

