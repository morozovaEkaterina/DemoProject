package sauceDemoTests.checkoutPersonalInfoTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on 'Cancel' button on the checkout person page")
public class CancelBtnOnCheckoutPersonPageTest extends BaseTest {

    @DisplayName("Check 'Cancel' button")
    @Test
    public void checkCancelBtnOnCheckoutPersonPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .clickOnCancelBtn();
    }
}
