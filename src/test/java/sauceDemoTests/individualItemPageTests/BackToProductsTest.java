package sauceDemoTests.individualItemPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on 'Back to products' button on the individual item page")
public class BackToProductsTest extends BaseTest {
    @DisplayName("Check 'Back to products' button")
    @Test
    public void BackToProductsBtnTest() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .checkElemsOnItemsCards()
                .clickOnItemTitle("Sauce Labs Fleece Jacket")
                .checkStaticElemsOnIndividualItemPage()
                .checkIsItemTheSame("Sauce Labs Fleece Jacket")
                .clickOnBackBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }
}

