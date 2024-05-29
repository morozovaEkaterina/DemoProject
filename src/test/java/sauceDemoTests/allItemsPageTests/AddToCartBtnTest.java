package sauceDemoTests.allItemsPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Test on 'Add to cart' button on the 'All Items' page")
public class AddToCartBtnTest extends BaseTest {

    @DisplayName("Check 'Add to cart' button for all items")
    @Test
    public void addToCartForAllItemsTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnAddToCartBtn("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")
                .checkClickOnAddToCartBtn();
    }

    @DisplayName("Check 'Add to cart' button for zero items")
    @Test
    public void addToCartAForZeroItemTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkClickOnAddToCartBtnNoItems();
    }

    @DisplayName("Check 'Add to cart' button for three items")
    @Test
    public void addToCartForAllThreeItemsTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnAddToCartBtn("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt")
                .checkClickOnAddToCartBtn();
    }

    @DisplayName("Check 'Add to cart' button from individual item page")
    @Test
    public void addToCartFromIndividualItemTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .clickOnItemTitle("Sauce Labs Fleece Jacket")
                .checkStaticElemsOnIndividualItemPage()
                .checkIsItemTheSame("Sauce Labs Fleece Jacket")
                .clickOnAddToCartBtn()
                .checkClickOnAddToCartBtn();
    }
}

