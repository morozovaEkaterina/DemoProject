package sauceDemoTests.checkoutItemPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on 'Cancel' button on the Item Info page")
public class CancelBtnOnCheckoutItemTest extends BaseTest {

    @DisplayName("Check 'Cancel' button on the Item Info page")
    @Test
    public void checkInputInfoOnCheckoutPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("kola", "kola", "dsp;ck")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnCancelBtn()
                .checkStaticElementsOnAllItemsPage()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }
}
