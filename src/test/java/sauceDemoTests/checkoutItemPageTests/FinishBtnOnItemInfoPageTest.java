package sauceDemoTests.checkoutItemPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on 'Finish' button on Item info page")
public class FinishBtnOnItemInfoPageTest extends BaseTest {
    @DisplayName("Check 'Finish' button on the item info page")
    @Test
    public void CheckFinishBtnCheckoutItemPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("Anna", "Novikova", "564151")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnFinishBtnCompletePage()
                .checkURL("https://www.saucedemo.com/checkout-complete.html");
    }
}
