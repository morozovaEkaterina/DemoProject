package sauceDemoTests.allItemsPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Test on 'Remove' button")
public class RemoveBtnTest extends BaseTest {

    @DisplayName("Check 'Remove' button for all items on the All items page")
    @Test
    public void removeBtnAllItemsTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnAddToCartBtn("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")
                .checkClickOnAddToCartBtn()
                .clickOnRemoveBtn("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")
                .checkCounterBadgeIsNotExist();
    }

    @DisplayName("Check 'Remove' button for three items on the All items page")
    @Test
    public void removeBtnThreeItemsTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnAddToCartBtn("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)")
                .checkClickOnAddToCartBtn()
                .clickOnRemoveBtn("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)")
                .checkCounterBadgeIsNotExist();
    }

    @DisplayName("Check 'Remove' button on the individual item page")
    @Test
    public void removeBtnFromItemDescriptionTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnItemTitle("Test.allTheThings() T-Shirt (Red)")
                .clickOnAddToCartBtn()
                .checkClickOnAddToCartBtn()
                .clickOnRemoveBtn()
                .checkClickOnRemoveBtn();
    }

    @DisplayName("Check 'Remove' button on cart  page")
    @Test
    public void removeBtnFromCartPageTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin("standard_user", "secret_sauce")
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnAddToCartBtn("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)")
                .checkClickOnAddToCartBtn()
                .clickOnCartBtn()
                .checkIsItemsTheSame("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)")
                .clickOnRemoveBtn("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt")
                .checkClickOnRemoveBtn("Sauce Labs Bike Light")
                .checkStaticElementsOnCartPage();
    }
}


