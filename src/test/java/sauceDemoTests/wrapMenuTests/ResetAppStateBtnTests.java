package sauceDemoTests.wrapMenuTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on 'Reset App State' button in the wrap menu")
public class ResetAppStateBtnTests extends BaseTest {

    @DisplayName("Check 'Reset App State' button in the wrap menu on the 'All Items' page")
    @Test
    public void checkResetAppStateBtnAllItemsPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnAddToCartBtn("Sauce Labs Backpack")
                .checkClickOnAddToCartBtn()
                .clickOnWrapMenu()
                .clickOnResetAppStateBtn()
                .checkClickResetAppStateBtn();
    }

    @DisplayName("Check 'Reset App State' button in the wrap menu on the cart page")
    @Test
    public void checkResetAppStateBtnCartPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnAddToCartBtn("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light")
                .checkClickOnAddToCartBtn()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnWrapMenu()
                .clickOnResetAppStateBtn()
                .checkClickResetAppStateBtn();
    }


    @DisplayName("Check 'Reset App State' button in the wrap menu in the checkout person page")
    @Test
    public void checkResetAppStateBtnCheckoutPersonPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnAddToCartBtn("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light")
                .checkClickOnAddToCartBtn()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .clickOnWrapMenu()
                .clickOnResetAppStateBtn()
                .checkClickResetAppStateBtn();
    }

    @DisplayName("Check 'Reset App State' button in the wrap menu on the checkout item page")
    @Test
    public void checkResetAppStateBtnCheckoutItemPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnAddToCartBtn("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light")
                .checkClickOnAddToCartBtn()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("Kate","Orlova","1204")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnWrapMenu()
                .clickOnResetAppStateBtn()
                .checkClickResetAppStateBtn();
    }

    @DisplayName("Check 'Reset App State' button in the wrap menu on  the individual item page")
    @Test
    public void checkResetAppStateBtnIndividualItemPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnAddToCartBtn("Sauce Labs Backpack","Sauce Labs Fleece Jacket","Sauce Labs Onesie")
                .checkClickOnAddToCartBtn()
                .clickOnItemTitle("Sauce Labs Backpack")
                .checkStaticElemsOnIndividualItemPage()
                .clickOnWrapMenu()
                .clickOnResetAppStateBtn()
                .checkClickResetAppStateBtn();
    }
}
