package sauceDemoTests.cartPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on 'Continue shopping' button on the cart page")
public class ContinueShoppingBtnOnCartPageTest extends BaseTest {

    @DisplayName("Check 'Continue shopping' button on the cart page")
    @Test
    public void checkContinueShoppingBtnTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnContinueShoppingBtn();
    }
}
