package sauceDemoTests.wrapMenuTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests 'all items' button in the wrap menu")
public class AllItemsBtnTest extends BaseTest {

    @DisplayName("Check 'all items' button on the All Items page")
    @Test
    public void checkAllItemsBtnAllItemsPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnWrapMenu()
                .clickOnAllItemsBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }

    @DisplayName("Check 'all items' button on the cart page")
    @Test
    public void checkAllItemsBtnCartPage() {

        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnWrapMenu()
                .clickOnAllItemsBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }

    @DisplayName("Check 'all items' button on the checkout person page")
    @Test
    public void checkAllItemsBtnCheckoutPersonalInfoPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .clickOnWrapMenu()
                .clickOnAllItemsBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }

    @DisplayName("Check 'all items' button on the checkout item page")
    @Test
    public void checkAllItemsBtnCheckoutItemPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("Yulia", "Loseva", "1235")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnWrapMenu()
                .clickOnAllItemsBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }

    @DisplayName("Check 'all items' button on the checkout complete page")
    @Test
    public void checkAllItemsBtnCheckoutCompletePage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("Yulia", "Loseva", "1235")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnFinishBtnCompletePage()
                .checkStaticElemsOnCheckoutCompletePage()
                .clickOnWrapMenu()
                .clickOnAllItemsBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }

    @DisplayName("Check 'all items' button on the individual item page")
    @Test
    public void checkAllItemsBtnIndividualItemPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnItemTitle("Sauce Labs Fleece Jacket")
                .checkStaticElemsOnIndividualItemPage()
                .clickOnWrapMenu()
                .clickOnAllItemsBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }
}
